package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderBundleDto;
import com.example.orderservice.entity.OrderBundle;
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
