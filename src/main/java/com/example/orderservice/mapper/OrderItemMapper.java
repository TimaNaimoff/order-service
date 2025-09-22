package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.entity.OrderItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.*;
import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PhotoMapper.class})
public interface OrderItemMapper {

    @Mapping(target = "fullPrice", source = "fullPrice", qualifiedByName = "bigDecimalToInteger")
    @Mapping(target = "purchasePrice", source = "purchasePrice", qualifiedByName = "bigDecimalToInteger")
    @Mapping(target = "paymentPrice", source = "paymentPrice", qualifiedByName = "bigDecimalToInteger")
    @Mapping(target = "characteristics", source = "characteristics", qualifiedByName = "jsonToObject")
    @Mapping(target = "skuCharacteristics", source = "skuCharacteristics", qualifiedByName = "jsonToList")
    @Mapping(target = "statusDto", source = "statusDto", qualifiedByName = "jsonToStatusDto")
    OrderItemDto toDto(OrderItem entity);

    @InheritInverseConfiguration
    @Mapping(target = "order", ignore = true) // чтобы не зациклиться
    OrderItem toEntity(OrderItemDto dto);

    // ===== кастомные мапперы =====
    @Named("bigDecimalToInteger")
    default Integer bigDecimalToInteger(BigDecimal value) {
        return value != null ? value.intValue() : null;
    }

    @Named("jsonToObject")
    default Object jsonToObject(String json) {
        if (json == null) return null;
        try {
            return new ObjectMapper().readValue(json, Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка парсинга JSON", e);
        }
    }

    @Named("jsonToList")
    default List<Object> jsonToList(String json) {
        if (json == null) return null;
        try {
            return new ObjectMapper().readValue(json, List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка парсинга JSON", e);
        }
    }

    @Named("jsonToStatusDto")
    default com.example.orderservice.dto.StatusDto jsonToStatusDto(String json) {
        if (json == null) return null;
        try {
            return new ObjectMapper().readValue(json, com.example.orderservice.dto.StatusDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка парсинга StatusDto JSON", e);
        }
    }
}
