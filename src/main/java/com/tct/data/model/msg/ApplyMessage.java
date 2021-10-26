package com.tct.data.model.msg;

import com.tct.data.model.ApplyInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:09
 * @Version 1.0
 * @description 申请信息统一结构形式
 */
@Data
public class ApplyMessage {

    /**
     * 源id，由源系统携带
     */
    private Long sourceId;

    /**
     * 策略id
     */
    private Integer strategyId;

    /**
     * 用户请求表示，用于验证原系统
     */
    private String token;

    /**
     * 申请人
     */
    private String applicant;

    /**
     * 申请凭证
     */
    private String certificate;

    /**
     * 数据项
     */
    private String data;

    public ApplyInfo toApplyInfo() {
        ApplyInfo applyInfo = new ApplyInfo();
        BeanUtils.copyProperties(this, applyInfo);
        return applyInfo;
    }

}
