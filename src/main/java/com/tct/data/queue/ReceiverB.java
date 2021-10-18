package com.tct.data.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hannibal
 * @Date: 2020/10/27 15:35
 * @Version 1.0
 * @description 接收回执消息
 */
@Component
@RabbitListener(queues = "feedback")
public class ReceiverB {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("接受者Lufei.demo.a  : " + hello);
    }
}
