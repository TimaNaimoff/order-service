package com.example.orderservice.exception;

public class PaymentFailedException extends BaseServiceException {
    public PaymentFailedException(String paymentId) {
        super("Payment failed for id " + paymentId, "PAYMENT_FAILED");
    }
}
