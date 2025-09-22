package com.example.orderservice.common.mapper;


import com.example.orderservice.common.dto.BonusProgramDto;
import com.example.orderservice.common.entity.BonusProgram;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BonusProgramMapper {
    BonusProgramDto toDto(BonusProgram bonusProgram);

    BonusProgram toEntity(BonusProgramDto bonusProgram);

    List<BonusProgramDto>toDtoList(List<BonusProgram>bonusPrograms);
}
