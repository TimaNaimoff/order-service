package com.example.orderservice.mapper;


import com.example.orderservice.dto.PhotoDto;
import com.example.orderservice.dto.ScheduleInfoDto;
import com.example.orderservice.entity.Photo;
import com.example.orderservice.entity.ScheduleInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    PhotoDto toDto(Photo entity);

    Photo toEntity(PhotoDto dto);

    List<PhotoDto> toDtoList(List<Photo>photoList);
}
