package com.tct.data;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tct.data.model.ApplyInfo;
import com.tct.data.model.AuditorInfo;
import com.tct.data.model.msg.ApplyMessage;
import com.tct.data.model.msg.FeedbackMessage;
import com.tct.data.queue.MessageProcessor;
import com.tct.data.service.ApplyInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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

    @Resource
    ApplyInfoService applyInfoService;

    @Test
    public void getCagalogue() {
        ApplyInfo applyInfo=applyInfoService.getById(64);
        System.out.println("直接输出："+applyInfo);
        System.out.println("toString直接输出："+applyInfo.toString());
        System.out.println("toJsonString直接输出："+ JSONObject.toJSONString(applyInfo));

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
    }


}
