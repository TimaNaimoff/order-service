package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderItemCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface OrderItemCharacteristicRepository extends JpaRepository<OrderItemCharacteristic, Long> {

    // Найти все характеристики по конкретному orderItem
    List<OrderItemCharacteristic> findByOrderItem_Id(Long orderItemId);

    // Найти все характеристики по названию (например "Цвет")
    List<OrderItemCharacteristic> findByTitle(String title);

    // Найти все характеристики по названию и конкретному orderItem
    List<OrderItemCharacteristic> findByOrderItem_IdAndTitle(Long orderItemId, String title);

    // Найти по названию + значению (например "Цвет" + "Красный")
    Optional<OrderItemCharacteristic> findByTitleAndValue(String title, String value);

    // Проверить, есть ли у orderItem характеристика с определённым названием
    boolean existsByOrderItem_IdAndTitle(Long orderItemId, String title);
}
