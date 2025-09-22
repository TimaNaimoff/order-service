package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderStatusDto;
import com.example.orderservice.entity.OrderStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    default OrderStatusDto toDto(OrderStatus status) {
        if (status == null) {
            return null;
        }
        return switch (status) {
            case CREATED -> new OrderStatusDto("Создан", "CREATED", "#000000", "#E0E0E0");
            case PAID -> new OrderStatusDto("Оплачен", "PAID", "#FFFFFF", "#4CAF50");
            case SHIPPED -> new OrderStatusDto("Отправлен", "SHIPPED", "#FFFFFF", "#2196F3");
            case DELIVERED -> new OrderStatusDto("Доставлен", "DELIVERED", "#FFFFFF", "#8BC34A");
            case CANCELLED -> new OrderStatusDto("Отменён", "CANCELLED", "#FFFFFF", "#F44336");
            default -> throw new IllegalArgumentException("Unknown status: " + status);
        };
    }

    default OrderStatus toEntity(OrderStatusDto dto) {
        if (dto == null || dto.getValue() == null) {
            return null;
        }
        return OrderStatus.valueOf(dto.getValue());
    }
}
