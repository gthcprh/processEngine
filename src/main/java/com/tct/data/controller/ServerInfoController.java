package com.tct.data.controller;

import com.tct.data.model.ServerInfo;
import com.tct.data.service.ServerInfoService;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>
 * 服务信息 前端控制器
 * </p>
 *
 * @author hannibal
 * @since 2021-10-18
 */
@Controller
@RequestMapping("/serverInfo")
public class ServerInfoController {

    @Resource
    ServerInfoService serverInfoService;

    @PostMapping("save")
    public Result save(@RequestBody ServerInfo serverInfo) {
        String serverName=serverInfo.getServerName();
        String owner=serverInfo.getOwner();
        if (ObjectUtils.isEmpty(serverName)) {
            return ResultGenerator.fail("服务名称不能为空");
        }
        if (ObjectUtils.isEmpty(owner)) {
            return ResultGenerator.fail("服务所有者不能为空");
        }
        if(serverInfoService.isRepeat(serverName,owner)){
            return ResultGenerator.fail("此所有者下已有该服务");
        }
        String token = DigestUtils.md5DigestAsHex((serverName + owner).getBytes());
        serverInfo.setToken(token);
        serverInfoService.save(serverInfo);
        return ResultGenerator.success();
    }

    @GetMapping("list")
    public Result list() {
        return ResultGenerator.success(serverInfoService.list());
    }
}

