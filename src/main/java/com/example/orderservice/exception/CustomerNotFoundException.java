package com.example.orderservice.exception;

public class CustomerNotFoundException extends BaseServiceException {
    public CustomerNotFoundException(Integer customerId) {
        super("Customer with id " + customerId + " not found", "CUSTOMER_NOT_FOUND");
    }
}