package com.tct.data.util;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: Hannibal
 * @Date: 2019/7/2 13:59
 * @Version 1.0
 * @description
 */
@Data
@ToString
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }


}
