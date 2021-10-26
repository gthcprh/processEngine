package com.tct.data.service;

import com.tct.data.model.StrategyConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tct.data.model.StrategyInfo;

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
     * 解析流程节点信息
     * @param strategyConfigId
     * @param node
     * @return
     */
    StrategyInfo getStrategyInfo(int strategyConfigId, int node);
}
