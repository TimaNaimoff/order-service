package com.example.orderservice.mapper;


import com.example.orderservice.dto.DayScheduleInfoDto;
import com.example.orderservice.entity.DayScheduleInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DayScheduleInfoMapper {

    DayScheduleInfoDto toDto(DayScheduleInfo entity);

    DayScheduleInfo toEntity(DayScheduleInfoDto dto);
}

