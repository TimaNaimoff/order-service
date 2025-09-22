package com.example.orderservice.delivery.mapper;


import com.example.orderservice.delivery.dto.DayScheduleInfoDto;
import com.example.orderservice.delivery.entity.DayScheduleInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DayScheduleInfoMapper {

    DayScheduleInfoDto toDto(DayScheduleInfo entity);

    DayScheduleInfo toEntity(DayScheduleInfoDto dto);
}

