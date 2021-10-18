package com.tct.data.model;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:09
 * @Version 1.0
 * @description 约定的申请信息统一结构形式
 */
@Data
public class Apply {

    private Long id;

    private Long strategyId;

    private String applyInfo;

    public ApplyInfo toApplyInfo(){
        ApplyInfo applyInfo=new ApplyInfo();
        BeanUtils.copyProperties(this,applyInfo);
        return applyInfo;
    }
}
