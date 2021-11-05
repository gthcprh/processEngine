package com.tct.data.service;

import com.tct.data.model.StrategyConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tct.data.model.StrategyInfo;
import com.tct.data.model.StrategyInfoVo;
import com.tct.data.util.RequestBean;
import com.tct.data.util.Result;

/**
 * <p>
 * 策略配置 服务类
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
public interface StrategyConfigService extends IService<StrategyConfig> {

    /**
     * 列表查询
     * @param name
     * @param requestBean
     * @return
     */
    Result selectList(String name, RequestBean requestBean);

    /**
     * 解析流程节点信息
     * @param strategyConfigId
     * @param node
     * @return
     */
    StrategyInfoVo getStrategyInfo(int strategyConfigId, int node);

    /**
     * 保存策略信息
     * @param strategyConfig
     * @return
     */
    Result saveApplyStrategy(StrategyConfig strategyConfig);

    /**
     * 修改策略信息
     * @param strategyConfig
     * @return
     */
    Result updateApplyStrategy(StrategyConfig strategyConfig);

    /**
     * 删除策略信息
     * @param strategyConfigId
     * @return
     */
    Result deleteApplyStrategy(Integer  strategyConfigId);
}
