package com.example.orderservice.exception;

public class CustomerNotFoundException extends BaseServiceException {
    public CustomerNotFoundException(Long customerId) {
        super("Customer with id " + customerId + " not found", "CUSTOMER_NOT_FOUND");
    }
    public CustomerNotFoundException(String message) {
        super(message, "CUSTOMER_NOT_FOUND");
    }
}