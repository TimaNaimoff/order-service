package com.example.orderservice.exception;

public class InvalidCustomerException extends BaseServiceException {
    public InvalidCustomerException(String message) {
        super(message, "INVALID_CUSTOMER");
    }
}
