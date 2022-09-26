package com.cj.common.exception;

import lombok.Data;

@Data
public class CJException extends RuntimeException {

    private int code;
    private String msg;

    public CJException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}