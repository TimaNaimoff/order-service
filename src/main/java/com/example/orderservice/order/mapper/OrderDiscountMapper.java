package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderDiscountDto;
import com.example.orderservice.entity.OrderDiscount;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderBundleMapper.class})
public interface OrderDiscountMapper {

    @Mapping(target = "order", ignore = true) // ⚡ не маппим Order, чтобы не было рекурсии
    OrderDiscountDto toDto(OrderDiscount entity);

    @InheritInverseConfiguration
    OrderDiscount toEntity(OrderDiscountDto dto);
}
