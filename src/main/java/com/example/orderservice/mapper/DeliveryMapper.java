package com.example.orderservice.mapper;

import com.example.orderservice.dto.DeliveryDto;
import com.example.orderservice.entity.Delivery;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ScheduleInfoMapper.class})
public interface DeliveryMapper {

    // entity -> dto
    @Mapping(target = "scheduleInfo", source = "scheduleInfo")
    DeliveryDto toDto(Delivery entity);

    // dto -> entity (обратный маппинг берётся автоматически)
    @InheritInverseConfiguration
    Delivery toEntity(DeliveryDto dto);
}
