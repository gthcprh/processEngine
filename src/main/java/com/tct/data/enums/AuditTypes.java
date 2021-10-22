package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 19:03
 * @Version 1.0
 * @description 审批类型
 */
public enum AuditTypes {

    /**
     * 审批类型枚举  SIMPLE  AND_AUDIT  OR_AUDIT
     */
    SIMPLE(1, "单一节点"),
    AND_APPROVE(2, "会签"),
    OR_APPROVE(3, "或签");

    /**
     * 编码
     */
    private final int type;

    /**
     * 名称
     */
    private final String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static AuditTypes getEnum(Integer value) {
        for (AuditTypes e : AuditTypes.values()) {
            if (value.equals(e.getType())) {
                return e;
            }
        }
        return null;
    }

    AuditTypes(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
