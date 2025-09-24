package com.example.orderservice.order.mapper;

import com.example.orderservice.common.mapper.BonusProgramMapper;
import com.example.orderservice.customer.mapper.CustomerMapper;
import com.example.orderservice.delivery.mapper.DeliveryMapper;
import com.example.orderservice.order.dto.OrderDto;
import com.example.orderservice.order.entity.Order;
import com.example.orderservice.payment.mapper.PaymentIntentionActionMapper;
import org.mapstruct.*;

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
    @Mapping(target = "paymentIntentionActions", ignore = true)
    @Mapping(target = "status", source = "status")              // явно указать
    @Mapping(target = "orderStatus", source = "orderStatusDto") // через OrderStatusMapper
    @Mapping(target = "paymentBlockTexts", source = "payment_block_texts")
    Order toEntity(OrderDto dto);

    // обновление существующего Entity
    @InheritConfiguration(name = "toEntity")
    void updateEntity(OrderDto dto, @MappingTarget Order entity);
}
