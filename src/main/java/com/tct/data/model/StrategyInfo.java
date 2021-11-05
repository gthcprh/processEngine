package com.tct.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 18:51
 * @Version 1.0
 * @description 节点策略详情
 */
@Data
public class StrategyInfo {

    private Integer type;

    private String targetName;

    private List<Integer> targetServer;

    private List<AuditorInfo> info;

    private String data;

}
