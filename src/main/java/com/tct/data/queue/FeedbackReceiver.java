package com.tct.data.queue;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.tct.data.enums.LogTypes;
import com.tct.data.exception.PeException;
import com.tct.data.model.MsgLog;
import com.tct.data.model.msg.FeedbackMessage;
import com.tct.data.service.MsgLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: Hannibal
 * @Date: 2020/10/27 15:35
 * @Version 1.0
 * @description 接收回执消息
 */
@Slf4j
@Component
@RabbitListener(queues = "${queue.feedback}")
public class FeedbackReceiver {

    @Resource
    MessageProcessor messageProcessor;

    @Resource
    MsgLogService msgLogService;

    @RabbitHandler
    public void process(String data, Channel channel, Message message) throws IOException {
        MsgLog msgLog = new MsgLog();
        msgLog.setData(data);
        msgLog.setType(LogTypes.AUDIT.getCode());
        FeedbackMessage feedbackMessage;
        try {
            feedbackMessage = JSONObject.parseObject(data, FeedbackMessage.class);
            String token=feedbackMessage.getToken();
            msgLog.setToken(token);
            if(!ResourceCache.serverInfos().containsKey(token)){
                msgLog.setDescription("token校验失败");
                log.error("token校验失败，已丢弃");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                msgLogService.save(msgLog);
                return ;
            }
        } catch (Exception e) {
            log.error("消息校验失败，已丢弃");
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            msgLog.setDescription(e.getMessage());
            msgLogService.save(msgLog);
            return;
        }

        try {
            messageProcessor.dealAuditFeedback(feedbackMessage);
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("消息消费成功");
            msgLog.setStatus(1);
        } catch (IOException e) {
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            log.error(e.getMessage(), e);
            msgLog.setDescription(e.getMessage());
        } catch (PeException p) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            msgLog.setDescription(p.getMessage());
        }
        msgLogService.save(msgLog);
    }
}
