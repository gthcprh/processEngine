package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 19:03
 * @Version 1.0
 * @description 日志状态
 */
public enum LogStatus {

    /**
     * 日志状态  FAIL  SUCCESS
     */
    FAIL(0, "失败"),
    SUCCESS(1, "成功");

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

    public static LogStatus getEnum(Integer value) {
        for (LogStatus e : LogStatus.values()) {
            if (value.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }

    LogStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
