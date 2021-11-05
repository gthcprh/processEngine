package com.tct.data.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 18:51
 * @Version 1.0
 * @description 节点策略详情
 */
@Data
public class StrategyInfoVo extends StrategyInfo{

    /**
     * 能否继续流转
     */
    private boolean status;
}
