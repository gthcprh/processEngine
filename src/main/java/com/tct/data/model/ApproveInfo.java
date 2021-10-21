package com.tct.data.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("approve_info")
public class ApproveInfo implements Serializable {

    private static final long serialVersionUID=1L;

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
     * 审批用户
     */
    @TableField("approver_id")
    private Long approverId;

    /**
     * 审批角色
     */
    @TableField("approver_role_id")
    private Integer approverRoleId;

    /**
     * 审批状态，0：不通过
1：通过
2：未审批
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
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
