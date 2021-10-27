package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/10/27 10:17
 * @Version 1.0
 * @description
 */
public enum StrategyTypes {

    /**
     * 策略类型  DISAGREE  AGREE  AUDITING
     */
    APPLY_AUDIT(1, "申请审批"),
    SERVER_INVOKE(2, "服务流转");

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

    public static StrategyTypes getEnum(Integer value) {
        for (StrategyTypes e : StrategyTypes.values()) {
            if (value.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }

    StrategyTypes(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
