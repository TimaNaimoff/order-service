package com.example.orderservice.order.mapper;

import com.example.orderservice.order.dto.OrderBundleDto;
import com.example.orderservice.order.entity.OrderBundle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderBundleMapper {

    @Mapping(target = "items", source = "items")
    OrderBundleDto toDto(OrderBundle entity);

    @InheritInverseConfiguration
    OrderBundle toEntity(OrderBundleDto dto);
}
