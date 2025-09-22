package com.example.orderservice.exception;


public class PaymentNotFoundException extends BaseServiceException {

    public PaymentNotFoundException(String intentionId) {
        super("Payment with intentionId " + intentionId + " not found", "PAYMENT_NOT_FOUND");
    }

    public PaymentNotFoundException(Long orderId) {
        super("Payment for orderId " + orderId + " not found", "PAYMENT_NOT_FOUND");
    }
}
