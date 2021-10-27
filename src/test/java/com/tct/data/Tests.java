package com.tct.data;

import com.alibaba.fastjson.JSONObject;
import com.tct.data.model.AuditorInfo;
import com.tct.data.model.msg.ApplyMessage;
import com.tct.data.model.msg.FeedbackMessage;
import com.tct.data.queue.MessageProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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


}
