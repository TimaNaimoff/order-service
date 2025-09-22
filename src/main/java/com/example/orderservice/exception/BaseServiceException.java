package com.example.orderservice.exception;


import lombok.Getter;

@Getter
public abstract class BaseServiceException extends RuntimeException {
    private final String code;

    protected BaseServiceException(String message, String code) {
        super(message);
        this.code = code;
    }
}

