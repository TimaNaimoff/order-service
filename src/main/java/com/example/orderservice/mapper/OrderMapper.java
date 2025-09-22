package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                CustomerMapper.class,
                DeliveryMapper.class,
                OrderItemMapper.class,
                OrderDiscountMapper.class,
                PaymentIntentionActionMapper.class,
                BonusProgramMapper.class,
                OrderStatusMapper.class
        }
)
public interface OrderMapper {

    @Mapping(target = "orderStatusDto", source = "orderStatus")
    @Mapping(target = "payment_block_texts", source = "paymentBlockTexts")
    OrderDto toDto(Order entity);

    @InheritInverseConfiguration
    @Mapping(target = "payments", ignore = true) // ⚡ пока нет PaymentDto
    Order toEntity(OrderDto dto);
}
