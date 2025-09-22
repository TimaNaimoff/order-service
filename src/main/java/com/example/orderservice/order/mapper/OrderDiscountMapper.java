package com.example.orderservice.order.mapper;

import com.example.orderservice.order.dto.OrderDiscountDto;
import com.example.orderservice.order.entity.OrderDiscount;
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
