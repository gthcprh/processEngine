package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 19:03
 * @Version 1.0
 * @description 日志类型
 */
public enum LogTypes {

    /**
     * 审批类型枚举  APPLY  AUDIT  INVOKE
     */
    APPLY(1, "申请消息"),
    AUDIT(2, "审批消息"),
    INVOKE(3, "服务调用");

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

    public static LogTypes getEnum(Integer value) {
        for (LogTypes e : LogTypes.values()) {
            if (value.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }

    LogTypes(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
