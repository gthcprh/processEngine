package com.tct.data.controller;


import com.alibaba.fastjson.JSONArray;
import com.tct.data.model.StrategyConfig;
import com.tct.data.model.StrategyInfo;
import com.tct.data.service.StrategyConfigService;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 策略配置 前端控制器
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Controller
@RequestMapping("/strategy")
public class StrategyConfigController {

    @Resource
    StrategyConfigService strategyConfigService;

    @PostMapping("saveApplyConfig")
    public Result saveApplyStrategyConfig(@RequestBody StrategyConfig strategyConfig){
        if(ObjectUtils.isEmpty(strategyConfig.getStrategyName())){
            return ResultGenerator.fail("策略名称不能为空");
        }
        if(ObjectUtils.isEmpty(strategyConfig.getStrategyDetail())){
            return ResultGenerator.fail("策略详情不能为空");
        }
        String info=strategyConfig.getStrategyDetail();
        try{
            List<StrategyInfo> strategyInfoList = JSONArray.parseArray(info,StrategyInfo.class);
            return strategyConfigService.saveApplyStrategy(strategyInfoList,strategyConfig.getStrategyName());
        }catch(Exception e){
            return ResultGenerator.fail("策略信息格式错误");
        }

    }
}

