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
        log.info(auditMessage.toString());
        //生成审批单
        log.info("开始生成审批单。。。。。。。。。。。。。。。。。。。。。。");
        return ResultGenerator.success("申请消息已被接收");

    }

}
