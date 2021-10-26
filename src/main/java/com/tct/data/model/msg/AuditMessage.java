package com.tct.data.model.msg;

import com.tct.data.model.ApplyInfo;
import com.tct.data.model.AuditorInfo;
import lombok.Data;

/**
 * @Author: Hannibal
 * @Date: 2021/10/11 18:09
 * @Version 1.0
 * @description 审批消息统一格式
 */
@Data
public class AuditMessage {

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
     * 当前节点类型编号
     */
    private Integer nodeTypeCode;

    /**
     * 当前节点类型名称
     */
    private String nodeTypeName;

    /**
     * 申请数据
     */
    private String data;

    /**
     * 申请信息
     */
    private ApplyInfo applyInfo;

    /**
     * 审批信息
     */
    private AuditorInfo auditorInfo;

}
