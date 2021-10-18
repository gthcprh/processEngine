package com.tct.data.enums;

/**
 * @Author: Hannibal
 * @Date: 2021/7/7 11:19
 * @Version 1.0
 * @description 返回结果枚举
 */
public enum NodeTypes {

    SIMPLE(0, "成功"),
    AND_(1, "失败"),
    FAIL(2, "失败");


    private final Integer code;

    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    NodeTypes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
