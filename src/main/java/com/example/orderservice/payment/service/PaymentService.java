package com.example.orderservice.payment.service;


import com.example.orderservice.exception.PaymentNotFoundException;
import com.example.orderservice.order.entity.Order;
import com.example.orderservice.payment.dto.PaymentIntentionActionDto;
import com.example.orderservice.payment.entity.Payment;
import com.example.orderservice.payment.entity.PaymentStatus;
import com.example.orderservice.payment.mapper.PaymentIntentionActionMapper;
import com.example.orderservice.payment.mapper.PaymentMapper;
import com.example.orderservice.payment.repository.PaymentIntentionActionRepository;
import com.example.orderservice.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import com.example.orderservice.payment.dto.PaymentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService  {
    private final PaymentRepository paymentRepository;
    private final PaymentIntentionActionMapper paymentIntentionActionMapper;
    private final PaymentIntentionActionRepository paymentIntentionActionRepository;
    private final PaymentMapper paymentMapper;

    @Transactional
    public PaymentDto createPayment(Order order,
                                    BigDecimal amount, String provider, String type) {

        Payment paymnent = Payment.builder().order(order).amount(amount).provider(provider)
                .type(type).status(PaymentStatus.CREATED).currency("SUM").
                        paymentUrl(generatePaymentUrl(order)).
                        intentionId(generateIntentionId(order)).
                        createdAt(LocalDateTime.now()).build();
        Payment saved = paymentRepository.save(paymnent);
        return paymentMapper.toDto(saved);
    }



    @Transactional(readOnly = true)
    public PaymentDto getLatestPaymentByOrder(Order order) {
        Payment payment = paymentRepository.findFirstByOrderOrderByCreatedAtDesc(order)
                .orElseThrow(() -> new PaymentNotFoundException(order.getId()));
        return paymentMapper.toDto(payment);
    }


    @Transactional
    public PaymentDto updatePaymentStatus(String intentionId, PaymentStatus status, String providerResponse) {
        Payment payment = paymentRepository.findByIntentionId(intentionId)
                .orElseThrow(() -> new PaymentNotFoundException(intentionId));

        payment.setStatus(status);
        payment.setProviderResponse(providerResponse);
        payment.setUpdatedAt(LocalDateTime.now());

        return paymentMapper.toDto(paymentRepository.save(payment));
    }


    @Transactional(readOnly = true)
    public List<PaymentIntentionActionDto> getPaymentIntentionActions(Order order) {
        return paymentIntentionActionRepository.
                findAllByOrder(order).stream().map(paymentIntentionActionMapper::toDto).
                collect(Collectors.toList());

    }


    private String generatePaymentUrl(Order order) {
        return "https://payment.provider/pay?orderId=" + order.getId();
    }

    private String generateIntentionId(Order order) {
        // Генерация уникального ID для транзакции
        return "INT-" + order.getId() + "-" + System.currentTimeMillis();
    }
}
