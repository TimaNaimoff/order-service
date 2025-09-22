package com.example.orderservice.exception;

public class PaymentNotFoundException extends BaseServiceException {
    public PaymentNotFoundException(String paymentId) {
        super("Payment not found for id " + paymentId, "PAYMENT_NOT_FOUND");
    }
}
