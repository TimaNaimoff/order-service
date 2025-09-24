package com.example.orderservice.delivery.service;

import com.example.orderservice.delivery.dto.DayScheduleInfoDto;
import com.example.orderservice.delivery.dto.DeliveryDto;
import com.example.orderservice.delivery.entity.DayScheduleInfo;
import com.example.orderservice.delivery.entity.Delivery;
import com.example.orderservice.delivery.mapper.DayScheduleInfoMapper;
import com.example.orderservice.delivery.mapper.DeliveryMapper;
import com.example.orderservice.delivery.repository.DayScheduleRepository;
import com.example.orderservice.delivery.repository.DeliveryRepository;
import com.example.orderservice.exception.DeliveryNotFoundException;
import com.example.orderservice.exception.InvalidOrderException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DayScheduleRepository dayScheduleRepository;
    private final DeliveryMapper deliveryMapper;
    private final DayScheduleInfoMapper dayScheduleInfoMapper;

    @Transactional(readOnly = true)
    public DeliveryDto getDeliveryPointById(Integer deliveryPointId){
         Delivery delivery = deliveryRepository.findByDeliveryPointId(deliveryPointId).
                 orElseThrow(()-> new DeliveryNotFoundException(deliveryPointId ));
         return deliveryMapper.toDto(delivery);
    }
    @Transactional(readOnly = true)
    public List<DeliveryDto>getDeliveriesByCityAndDistrict(Integer cityId,Integer districtId){
        List<Delivery>deliveries = deliveryRepository.findAllByCityIdAndDistrictId(cityId,districtId);
        if(deliveries.isEmpty()){
            throw new DeliveryNotFoundException("No deliveries found for cityId=" + cityId + ", districtId=" + districtId);
        }
        return deliveryMapper.toDtoList(deliveries);
    }
    @Transactional(readOnly = true)
    public boolean deliveryPointExists(String deliveryPointKey){
        return deliveryRepository.existsByDeliveryPointKey(deliveryPointKey);
    }
    @Transactional(readOnly = true)
    public List<DayScheduleInfoDto>getAvailableDays(Long scheduleInfoId){
        List<DayScheduleInfo>days=dayScheduleRepository.findAllByScheduleInfoId(scheduleInfoId);
        return days.stream().map(dayScheduleInfoMapper::toDto).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public boolean isDeliveryAvailable(Long scheduleInfoId,String day){
        return dayScheduleRepository.findByDay(day).map(DayScheduleInfo::getDayOff).
                map(off->!off).orElse(false);
    }

    @Transactional(readOnly = true)
    public boolean isDeliveryAvailableOnDay(Long scheduleInfoId, String day) {
        return dayScheduleRepository.findByDay(day)
                .map(DayScheduleInfo::getDayOff)
                .map(off -> !off)
                .orElse(false);
    }

    @Transactional(readOnly = true)
    public List<DeliveryDto> getDeliveriesByStatus(String status) {
        List<Delivery> deliveries = deliveryRepository.findAllByDeliveryStatus(status);
        if (deliveries.isEmpty()) {
            throw new DeliveryNotFoundException("No deliveries found with status=" + status);
        }
        return deliveryMapper.toDtoList(deliveries);
    }

    /**
     * Получение точек доставки по типу
     */
    @Transactional(readOnly = true)
    public List<DeliveryDto> getDeliveriesByType(String type) {
        List<Delivery> deliveries = deliveryRepository.findAllByDeliveryType(type);
        if (deliveries.isEmpty()) {
            throw new DeliveryNotFoundException("No deliveries found with type=" + type);
        }
        return deliveryMapper.toDtoList(deliveries);
    }

    /**
     * Получение точек доставки по зоне
     */
    @Transactional(readOnly = true)
    public List<DeliveryDto> getDeliveriesByZone(Integer zoneId) {
        List<Delivery> deliveries = deliveryRepository.findAllByZoneId(zoneId);
        if (deliveries.isEmpty()) {
            throw new DeliveryNotFoundException("No deliveries found for zoneId=" + zoneId);
        }
        return deliveryMapper.toDtoList(deliveries);
    }

    @Transactional
    public DeliveryDto assignDelivery(Long orderId, DeliveryDto deliveryDto) {
        log.info("Assigning delivery to orderId={}, delivery={}", orderId, deliveryDto);

        if (deliveryDto == null) {
            throw new InvalidOrderException("Delivery info is required for orderId=" + orderId);
        }

        var delivery = deliveryMapper.toEntity(deliveryDto);
        delivery.setId(orderId); // связь "доставка ↔ заказ"

        var saved = deliveryRepository.save(delivery);
        return deliveryMapper.toDto(saved);
    }

}


