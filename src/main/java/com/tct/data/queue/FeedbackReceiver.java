package com.tct.data.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hannibal
 * @Date: 2020/10/27 15:35
 * @Version 1.0
 * @description 接收回执消息
 */
@Slf4j
@Component
@RabbitListener(queues = "tct.feedback")
public class FeedbackReceiver {

    @RabbitHandler
    public void process(String hello) {
       log.info("反馈队列消息: " + hello);
    }
}
