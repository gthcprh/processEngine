package com.tct.data.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tct.data.model.StrategyConfig;
import com.tct.data.dao.StrategyConfigMapper;
import com.tct.data.service.StrategyConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 策略配置 服务实现类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@Service
public class StrategyConfigServiceImpl extends ServiceImpl<StrategyConfigMapper, StrategyConfig> implements StrategyConfigService {

    public void saveStrategy(String strategyInfo){

    }

    public void checkStrategyFormat(String strategyInfo){

        JSONArray jsonArray=JSONArray.parseArray(strategyInfo);

        for(int i=0,l=jsonArray.size();i<l;i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
        }
    }
}
