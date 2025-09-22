package com.example.orderservice.exception;

public class DeliveryNotFoundException extends BaseServiceException {
    public DeliveryNotFoundException(Long deliveryId) {
        super("Delivery not found for id " + deliveryId, "DELIVERY_NOT_FOUND");
    }

    public DeliveryNotFoundException(Integer deliveryPointId) {
        super("Delivery with pointId " + deliveryPointId + " not found", "DELIVERY_NOT_FOUND");
    }

    public DeliveryNotFoundException(String message) {
        super(message, "DELIVERY_NOT_FOUND");
    }

}
