package com.example.orderservice.exception;

public class DeliveryUnavailableException extends BaseServiceException {
    public DeliveryUnavailableException(String deliveryId) {
        super("Delivery unavailable for id " + deliveryId, "DELIVERY_UNAVAILABLE");
    }
}
