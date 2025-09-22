package com.example.orderservice.mapper;

import com.example.orderservice.dto.PaymentIntentionActionDto;
import com.example.orderservice.entity.PaymentIntentionAction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentIntentionActionMapper {

    PaymentIntentionActionDto toDto(PaymentIntentionAction entity);

    @Mapping(target = "order", ignore = true)
    PaymentIntentionAction toEntity(PaymentIntentionActionDto dto);

    List<PaymentIntentionActionDto> toDtoList(List<PaymentIntentionAction> entities);
    List<PaymentIntentionAction> toEntityList(List<PaymentIntentionActionDto> dtos);
}

