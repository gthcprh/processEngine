package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 19:03
 * @Version 1.0
 * @description 审批类型
 */
public enum AuditStatus {

    /**
     * 审批类型枚举  DISAGREE  AGREE  AUDITING
     */
    DISAGREE(0, "不同意"),
    AGREE(1, "同意"),
    AUDITING(2, "审批中"),
    REVOKE(3, "已撤回");

    /**
     * 编码
     */
    private final int code;

    /**
     * 名称
     */
    private final String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static AuditStatus getEnum(Integer value) {
        for (AuditStatus e : AuditStatus.values()) {
            if (value.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }

    AuditStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
