package com.example.orderservice.exception;

public class DeliveryNotFoundException extends BaseServiceException {
    public DeliveryNotFoundException(String deliveryId) {
        super("Delivery not found for id " + deliveryId, "DELIVERY_NOT_FOUND");
    }
}
