package com.learning.spring.spring5.exception;

public class BadPathParamException extends RuntimeException {

    public BadPathParamException(String error) {
        super(error);
    }
}
