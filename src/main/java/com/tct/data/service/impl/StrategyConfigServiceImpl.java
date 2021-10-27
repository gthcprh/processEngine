package com.tct.data.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tct.data.enums.AuditTypes;
import com.tct.data.enums.StrategyTypes;
import com.tct.data.model.StrategyConfig;
import com.tct.data.dao.StrategyConfigMapper;
import com.tct.data.model.StrategyInfo;
import com.tct.data.service.StrategyConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

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

    @Override
    public StrategyInfo getStrategyInfo(int strategyConfigId, int node){
        StrategyConfig strategyConfig=this.getById(strategyConfigId);
        String info = strategyConfig.getStrategyDetail();
        JSONArray jsonArray = JSONArray.parseArray(info);
        StrategyInfo strategyInfo = jsonArray.getObject(node - 1, StrategyInfo.class);
        strategyInfo.setStatus(jsonArray.size()!=node);
        return strategyInfo;
    }

    @Override
    public Result saveApplyStrategy(List<StrategyInfo> strategyInfoList, String  strategyName){
        for(StrategyInfo strategyInfo:strategyInfoList){
            int nodeType=strategyInfo.getType();
            if(ObjectUtils.isEmpty(nodeType)|| ObjectUtils.isEmpty(AuditTypes.getEnum(nodeType))){
                return ResultGenerator.fail("节点类型为空或者不在枚举值中");
            }
            if(CollectionUtils.isEmpty(strategyInfo.getTargetServer())||CollectionUtils.isEmpty(strategyInfo.getInfo())){
                return ResultGenerator.fail("节点服务为空或者节点信息为空");
            }
            if(strategyInfo.getTargetServer().size()!=strategyInfo.getInfo().size()){
                return ResultGenerator.fail("节点服务个数与服务信息数对应不上");
            }
        }
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setStrategyName(strategyName);
        strategyConfig.setStrategyType(StrategyTypes.APPLY_AUDIT.getCode());
        strategyConfig.setStrategyDetail(JSONObject.toJSONString(strategyInfoList));
        this.save(strategyConfig);
        return ResultGenerator.success();
    }
}
