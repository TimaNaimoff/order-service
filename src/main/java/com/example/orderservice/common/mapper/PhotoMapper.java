package com.example.orderservice.common.mapper;



import com.example.orderservice.common.dto.PhotoDto;
import com.example.orderservice.common.entity.Photo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    PhotoDto toDto(Photo entity);

    Photo toEntity(PhotoDto dto);

    List<PhotoDto> toDtoList(List<Photo>photoList);
}
