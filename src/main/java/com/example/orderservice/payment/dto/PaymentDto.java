package com.example.orderservice.payment.dto;

import com.example.orderservice.order.entity.Order;
import com.example.orderservice.payment.entity.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long id;

    private Order order;

    private String provider;

    private String type;

    private BigDecimal amount;

    private String currency = "SUM";

    private PaymentStatus status;

    private String paymentUrl;    // ссылка для редиректа
    private String intentionId;   // id транзакции у провайдера

    private String providerResponse; // JSON от платёжки

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}