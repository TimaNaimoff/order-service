package com.example.orderservice.exception;

public class InvalidOrderException extends BaseServiceException {
    public InvalidOrderException(String message) {
        super(message, "INVALID_ORDER");
    }
}
