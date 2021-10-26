package com.tct.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Hannibal
 * @Date: 2021/10/21 11:48
 * @Version 1.0
 * @description 审批人信息
 */
@Data
@AllArgsConstructor
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
    private Integer auditRoleId;
}
