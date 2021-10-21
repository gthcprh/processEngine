package com.tct.data.model;

import lombok.Data;

/**
 * @Author: Hannibal
 * @Date: 2021/10/21 11:48
 * @Version 1.0
 * @description
 */
@Data
public class ApproverInfo {

    /**
     * 审批用户
     */
    private String approver;

    /**
     * 审批用户id
     */
    private Long approverId;

    /**
     * 审批角色
     */
    private String approveRole;

    /**
     * 审批角色id
     */
    private Long approveRoleId;
}
