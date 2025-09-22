package com.example.orderservice.mapper;


import com.example.orderservice.dto.ScheduleInfoDto;
import com.example.orderservice.entity.ScheduleInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DayScheduleInfoMapper.class})
public interface ScheduleInfoMapper {

    @Mapping(target = "days", source = "days")
    ScheduleInfoDto toDto(ScheduleInfo entity);

    @Mapping(target = "days", source = "days")
    ScheduleInfo toEntity(ScheduleInfoDto dto);

    List<ScheduleInfoDto>toDtoList(List<ScheduleInfo>scheduleInfoList);
}
