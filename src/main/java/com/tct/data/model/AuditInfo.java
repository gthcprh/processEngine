package com.tct.data.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 审批记录表
 * </p>
 *
 * @author hannibal
 * @since 2021-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("audit_info")
public class AuditInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审批ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 申请编号
     */
    @TableField("apply_id")
    private Long applyId;

    /**
     * apiId
     */
    @TableField("api_id")
    private Integer apiId;

    /**
     * 当前节点
     */
    @TableField("current_node")
    private Integer currentNode;

    /**
     * 审批用户
     */
    @TableField("auditor_id")
    private Long auditorId;

    /**
     * 审批角色
     */
    @TableField("audit_role_id")
    private Integer auditRoleId;

    /**
     * 审批状态，0：不通过
     * 1：通过
     * 2：未审批
     */
    @TableField("status")
    private Integer status;

    /**
     * 审批信息
     */
    @TableField("audit_info")
    private String auditInfo;

    /**
     * 审批单生成时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
