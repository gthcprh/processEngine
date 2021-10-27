package com.tct.data.controller;

import com.tct.data.model.msg.AuditMessage;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: Hannibal
 * @Date: 2021/10/26 14:26
 * @Version 1.0
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class DemoController {

    @PostMapping("audit")
    public Result auditMsg(@RequestBody AuditMessage auditMessage) {
        log.info("接收到待审批消息："+auditMessage.toString());
        //生成审批单
        log.info("开始生成审批单。。。。。。。。。。。。。。。。。。。。。。");
        return ResultGenerator.success("申请消息已被接收");

    }

    @PostMapping("feedback")
    public Result feedback(@RequestBody Map map) {
        log.info("接收到反馈消息:"+map);
        //生成审批单
        return ResultGenerator.success("反馈消息已被接收");

    }
}
