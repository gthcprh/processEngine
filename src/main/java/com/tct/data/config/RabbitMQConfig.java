package com.tct.data.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author: Hannibal
 * @Date: 2020/10/26 18:19
 * @Version 1.0
 * @description RabbitMQ配置类
 */
@Slf4j
@Component
public class RabbitMQConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Resource
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 消息发送回调函数（只对异常消息做记录）
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            log.error("消息唯一标识:" + correlationData);
            log.error("确认结果:" + ack);
            log.error("失败原因:" + cause);
        }
    }

    /**
     * 交换机路由不到队列触发（正常情况下不会触发）
     * @param message
     * @param replyCode
     * @param replytext
     * @param exchanges
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replytext, String exchanges, String routingKey) {
        log.info("消息主题 message:" + message);
        log.info("消息主题 message:" + replyCode);
        log.info("描述:" + replytext);
        log.info("消息使用交换器:" + exchanges);
        log.info("消息使用路由:" + routingKey);
    }
}
