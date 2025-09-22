package com.example.orderservice.order.mapper;

import com.example.orderservice.order.dto.OrderItemCharacteristicDto;
import com.example.orderservice.order.entity.OrderItemCharacteristic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemCharacteristicMapper {

    OrderItemCharacteristicDto toDto(OrderItemCharacteristic entity);
    @InheritInverseConfiguration
    @Mapping(target = "orderItem", ignore = true)
    OrderItemCharacteristic toEntity(OrderItemCharacteristicDto entity);

    List<OrderItemCharacteristicDto> toDtoList(List<OrderItemCharacteristic> entityList);


}
