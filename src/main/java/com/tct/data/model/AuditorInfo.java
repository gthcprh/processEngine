package com.tct.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Hannibal
 * @Date: 2021/10/21 11:48
 * @Version 1.0
 * @description 审批人信息
 */
@Data
@NoArgsConstructor
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

    public AuditorInfo(String auditor, Integer auditorId, String auditRole, Integer auditRoleId) {
        this.auditor = auditor;
        this.auditorId = (long) auditorId;
        this.auditRole = auditRole;
        this.auditRoleId = auditRoleId;
    }

}
