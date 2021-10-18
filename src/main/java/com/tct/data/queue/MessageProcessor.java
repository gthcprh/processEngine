package com.tct.data.queue;

import com.alibaba.fastjson.JSONObject;
import com.tct.data.model.Apply;
import com.tct.data.model.ApplyInfo;
import com.tct.data.model.StrategyConfig;
import com.tct.data.service.ApplyInfoService;
import com.tct.data.service.StrategyConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:26
 * @Version 1.0
 * @description
 */
@Slf4j
@Component
public class MessageProcessor {

    @Resource
    StrategyConfigService strategyConfigService;

    @Resource
    ApplyInfoService applyInfoService;

    /**
     * 处理申请队列消息
     * @param data
     */
    public void dealApply(String data){
        Apply apply;
        try{
            apply= JSONObject.parseObject(data, Apply.class);
        }catch (Exception e){
            log.error("消息校验失败");
            return;
        }
        ApplyInfo applyInfo=apply.toApplyInfo();
        applyInfo.setStatus(2);
        applyInfoService.save(applyInfo);

        StrategyConfig strategyConfig=strategyConfigService.getById(applyInfo.getStrategyId());
        strategyConfig.getStrategyDetail();
    }

    /**
     * 处理回执队列消息
     * @param data
     */

}
