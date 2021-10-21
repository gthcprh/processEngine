package com.tct.data;

import com.tct.data.model.msg.ApplyMessage;
import com.tct.data.queue.MessageProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Hannibal
 * @Date: 2020/11/16 16:29
 * @Version 1.0
 * @description
 */
@SpringBootTest
public class Tests {

    @Resource
    MessageProcessor messageProcessor;
    @Test
    public void getCagalogue() {
        System.out.println(123);
    }

    @Test
    public void test1() {
        ApplyMessage applyMessage=new ApplyMessage();
        applyMessage.setSourceId(2021101900001L);
        applyMessage.setApplicant("小明");
        applyMessage.setToken("1234");
        applyMessage.setStrategyId(1);
        applyMessage.setData("聚千界则为小千世界");
        messageProcessor.dealApply(applyMessage);
    }

}
