package com.example.orderservice.payment.mapper;

import com.example.orderservice.payment.dto.PaymentDto;
import com.example.orderservice.payment.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDto toDto(Payment payment);
    Payment toEntity(PaymentDto payment);
}
