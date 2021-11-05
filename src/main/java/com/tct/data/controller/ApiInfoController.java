package com.tct.data.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tct.data.model.ApiInfo;
import com.tct.data.service.ApiInfoService;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 服务信息 前端控制器
 * </p>
 *
 * @author hannibal
 * @since 2021-10-18
 */
@RestController
@RequestMapping("/apiInfo")
public class ApiInfoController {

    @Resource
    ApiInfoService apiInfoService;

    @GetMapping("list")
    public Result list(Integer serverId){
        QueryWrapper<ApiInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ApiInfo::getType,1);
        if(!ObjectUtils.isEmpty(serverId)){
            queryWrapper.lambda().eq(ApiInfo::getServiceId,serverId);
        }
        return ResultGenerator.success(apiInfoService.list(queryWrapper));
    }

}

