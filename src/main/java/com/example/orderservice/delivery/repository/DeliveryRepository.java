package com.example.orderservice.delivery.repository;

import com.example.orderservice.delivery.dto.DeliveryDto;
import com.example.orderservice.delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    Optional<Delivery> findByDeliveryPointId(Integer deliveryPointId);

    List<Delivery> findAllByCityIdAndDistrictId(Integer cityId, Integer districtId);

    List<Delivery> findAllByDeliveryStatus(String deliveryStatus);

    List<Delivery> findAllByDeliveryType(String deliveryType);

    boolean existsByDeliveryPointKey(String deliveryPointKey);

    List<Delivery> findAllByZoneId(Integer zoneId);
}
