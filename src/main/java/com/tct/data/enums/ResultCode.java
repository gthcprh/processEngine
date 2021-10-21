package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/7/7 11:19
 * @Version 1.0
 * @description 返回结果枚举
 */
public enum ResultCode {

    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    ERROR(998, "错误"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(999, "系统错误"),

    PARAM_EMPTY(50001,"参数缺失"),
    PARAM_ERROR(50002,"参数错误"),
    ;
    private final int code;

    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
