package com.tct.data.queue;

import com.tct.data.service.ApplyInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Hannibal
 * @Date: 2020/10/27 15:35
 * @Version 1.0
 * @description 接收申请消息
 */
@Slf4j
@Component
@RabbitListener(queues = "apply")
public class ReceiverA {

    @Resource
    MessageProcessor messageProcessor;

    @RabbitHandler
    public void process(String data) {
        messageProcessor.dealApply(data);
        log.info("申请通道接收消息："+data);
    }
}
