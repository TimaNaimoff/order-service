package com.example.orderservice.common.service;

import com.example.orderservice.common.dto.BonusProgramDto;
import com.example.orderservice.common.dto.PhotoDto;
import com.example.orderservice.common.entity.BonusProgram;
import com.example.orderservice.common.entity.Photo;
import com.example.orderservice.common.mapper.BonusProgramMapper;
import com.example.orderservice.common.mapper.PhotoMapper;
import com.example.orderservice.common.repository.BonusProgramRepository;
import com.example.orderservice.common.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final BonusProgramRepository bonusProgramRepository;
    private final BonusProgramMapper bonusProgramMapper;

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    @Transactional(readOnly = true)
    public List<BonusProgramDto> getAllActiveBonusProgram(){
        List<BonusProgram> activePrograms = bonusProgramRepository.findAllByOkTrue();
        return bonusProgramMapper.toDtoList(activePrograms);
    }

    @Transactional(readOnly = true)
    public Optional<BonusProgramDto> getBonusProgramByText(String text){
        return bonusProgramRepository.findByText(text)
                .map(bonusProgramMapper::toDto);
    }


    @Transactional
    public BonusProgramDto createOrUpdateBonusProgram(BonusProgramDto dto) {
        BonusProgram entity = bonusProgramMapper.toEntity(dto);
        return bonusProgramMapper.toDto(bonusProgramRepository.save(entity));
    }

    @Transactional
    public void deleteBonusProgram(Long id) {
        bonusProgramRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public Optional<PhotoDto> getPhotoByKey(String photoKey) {
        return photoRepository.findByPhotoKey(photoKey)
                .map(photoMapper::toDto);
    }

    @Transactional
    public PhotoDto createOrUpdatePhoto(PhotoDto dto) {
        Photo entity = photoMapper.toEntity(dto);
        return photoMapper.toDto(photoRepository.save(entity));
    }

    @Transactional
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}










