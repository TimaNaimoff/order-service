package com.example.orderservice.exception;

public class OrderNotFoundException extends BaseServiceException {
    public OrderNotFoundException(Long orderId) {
        super("Order with id " + orderId + " not found", "ORDER_NOT_FOUND");
    }
}
