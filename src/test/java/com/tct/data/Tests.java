package com.tct.data;

import com.alibaba.fastjson.JSONArray;
import com.sun.javaws.progress.Progress;
import com.tct.data.model.StrategyConfig;
import com.tct.data.model.StrategyInfo;
import com.tct.data.queue.MessageProcessor;
import com.tct.data.queue.ResourceCache;
import com.tct.data.service.ApplyInfoService;
import com.tct.data.service.StrategyConfigService;
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

    @Resource
    ApplyInfoService applyInfoService;

    @Resource
    StrategyConfigService strategyConfigService;

    @Test
    public void getCatalogue() {
        StrategyConfig strategyConfig = strategyConfigService.getById(7);
        String info = strategyConfig.getStrategyDetail();
        List<StrategyInfo> strategyInfoList = JSONArray.parseArray(info, StrategyInfo.class);
        System.out.println(strategyInfoList);
    }

    public static void main(String[] args) {

    }
}
