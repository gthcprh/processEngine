package com.tct.data.exception;

/**
 * @Author: Hannibal
 * @Date: 2020/10/26 18:19
 * @Version 1.0
 * @description 自定义异常
 */
public class PeException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public PeException(String message) {

        this.message = message;
    }

}



