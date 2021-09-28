package com.tct.data.util;

import com.tct.data.enums.ResultCode;

/**
 * 响应结果生成工具
 *
 * @Author: Hannibal
 * @Date: 2019/7/2 13:59
 * @Version 1.0
 * @description
 */
public class ResultGenerator {

    public static Result success() {
        return genResult(ResultCode.SUCCESS);
    }

    public static Result success(Object data) {
        Result result = genResult(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        return genResult(ResultCode.FAIL);
    }

    public static Result fail(String message) {
        Result result = new Result();
        result.setResultCode(ResultCode.FAIL.getCode());
        result.setMessage(message);
        return result;
    }

    public static Result genResult(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    public static Result genResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }

}
