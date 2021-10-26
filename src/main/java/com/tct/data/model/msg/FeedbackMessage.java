package com.tct.data.model.msg;

import com.tct.data.model.AuditorInfo;
import lombok.Data;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:09
 * @Version 1.0
 * @description 审批消息统一格式
 */
@Data
public class FeedbackMessage {

    /**
     * 全局唯一id
     */
    private Long msgId;

    /**
     * 审批id（全局唯一）
     */
    private Long auditId;

    /**
     * 当前节点
     */
    private Integer currentNode;

    /**
     * 用户请求标识，用于验证原系统
     */
    private String token;

    /**
     * 数据
     */
    private String data;

    /**
     * 审批结果
     */
    private Integer auditResult;

    /**
     * 审批信息
     */
    private String auditInfo;

    /**
     * 审批信息
     */
    private AuditorInfo auditorInfo;
}
