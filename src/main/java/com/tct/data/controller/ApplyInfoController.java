package com.tct.data.controller;


import com.tct.data.model.ServerInfo;
import com.tct.data.service.ApplyInfoService;
import com.tct.data.service.ServerInfoService;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 申请信息 前端控制器
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@RestController
@RequestMapping("/apply")
public class ApplyInfoController {

    @Resource
    ServerInfoService serverInfoService;

    @Resource
    ApplyInfoService applyInfoService;

    @GetMapping("progress")
    public Result progress(Long msgId) {
        if(ObjectUtils.isEmpty(applyInfoService.getById(msgId))){
            return ResultGenerator.fail("找不到对应的申请信息，msgId:"+msgId);
        }
        return applyInfoService.progress(msgId);
    }

    @GetMapping("progress2")
    public Result progress(Long applyId, HttpServletRequest request) {
        String token = request.getHeader("token");
        if (ObjectUtils.isEmpty(token)) {
            return ResultGenerator.fail("token缺失");
        }
        ServerInfo serverInfo = serverInfoService.getByToken(token);
        if (ObjectUtils.isEmpty(serverInfo)) {
            return ResultGenerator.fail("token校验失败");
        }
        return applyInfoService.progress(applyId);
    }
}

