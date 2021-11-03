package com.tct.data.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tct.data.enums.AuditTypes;
import com.tct.data.enums.StrategyTypes;
import com.tct.data.exception.PeException;
import com.tct.data.model.ApplyInfo;
import com.tct.data.model.StrategyConfig;
import com.tct.data.dao.StrategyConfigMapper;
import com.tct.data.model.StrategyInfo;
import com.tct.data.service.ApplyInfoService;
import com.tct.data.service.StrategyConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tct.data.util.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
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

    @Resource
    ApplyInfoService applyInfoService;

    @Override
    public Result selectList(String name, RequestBean requestBean){
        Page page = new PageQuery(requestBean);
        QueryWrapper<StrategyConfig> queryWrapper=new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(name)){
            queryWrapper.lambda().like(StrategyConfig::getStrategyName,name);
        }
        Result result = ResultGenerator.success(new PageResult(this.page(page, queryWrapper)));
        return result;
    }

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
    public Result saveApplyStrategy(StrategyConfig strategyConfig){
        List<StrategyInfo> strategyInfoList=strategyConfig.getStrategyInfos();
        try{
            checkStructure(strategyInfoList);
        }catch (PeException p){
            return ResultGenerator.fail(p.getMessage());
        }
        strategyConfig.setStrategyType(StrategyTypes.APPLY_AUDIT.getCode());
        strategyConfig.setStrategyDetail(JSONObject.toJSONString(strategyInfoList));
        this.save(strategyConfig);
        return ResultGenerator.success();
    }

    @Override
    public Result updateApplyStrategy(StrategyConfig strategyConfig){
        List<StrategyInfo> strategyInfoList=strategyConfig.getStrategyInfos();
        try{
            checkStructure(strategyInfoList);
        }catch (PeException p){
            return ResultGenerator.fail(p.getMessage());
        }
        strategyConfig.setStrategyDetail(JSONObject.toJSONString(strategyInfoList));

        UpdateWrapper<StrategyConfig> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(StrategyConfig::getId,strategyConfig.getId())
                .set(StrategyConfig::getStrategyDetail,strategyConfig.getStrategyDetail())
                .set(StrategyConfig::getDescription,strategyConfig.getDescription());
        this.update(updateWrapper);
        return ResultGenerator.success();
    }

    @Override
    public Result deleteApplyStrategy(Integer strategyConfigId) {

        if(ObjectUtils.isEmpty(this.getById(strategyConfigId))){
            return ResultGenerator.fail("该策略不存在");
        }
        QueryWrapper<ApplyInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(ApplyInfo::getStrategyId,strategyConfigId);
        List<ApplyInfo> list=applyInfoService.list(queryWrapper);
        if(!CollectionUtils.isEmpty(list)){
            return ResultGenerator.fail("该策略正在被其他申请使用");
        }
        this.removeById(strategyConfigId);
        return ResultGenerator.success();
    }

    /**
     * 校验并转化策略详情
     * @param strategyInfoList
     * @return
     */
    public boolean checkStructure(List<StrategyInfo> strategyInfoList){
        for(StrategyInfo strategyInfo:strategyInfoList){
            int nodeType=strategyInfo.getType();
            if(ObjectUtils.isEmpty(nodeType)|| ObjectUtils.isEmpty(AuditTypes.getEnum(nodeType))){
                throw new PeException("节点类型为空或者不在枚举值中");
            }
            if(CollectionUtils.isEmpty(strategyInfo.getTargetServer())||CollectionUtils.isEmpty(strategyInfo.getInfo())){
                throw new PeException("节点服务为空或者节点信息为空");
            }
            if(strategyInfo.getTargetServer().size()!=strategyInfo.getInfo().size()){
                throw new PeException("节点服务个数与服务信息数对应不上");
            }
        }
        return true;
    }
}
