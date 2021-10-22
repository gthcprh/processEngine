package com.tct.data.model;

import lombok.Data;

/**
 * @Author: Hannibal
 * @Date: 2021/10/21 11:48
 * @Version 1.0
 * @description
 */
@Data
public class AuditorInfo {

    /**
     * 审批用户
     */
    private String auditor;

    /**
     * 审批用户id
     */
    private Long auditorId;

    /**
     * 审批角色
     */
    private String auditRole;

    /**
     * 审批角色id
     */
    private Long auditRoleId;
}
