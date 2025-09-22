package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // найти все айтемы по id заказа
    List<OrderItem> findByOrder_Id(Long orderId);

    // найти айтемы по SKU
    List<OrderItem> findBySkuId(Integer skuId);

    // найти айтемы по статусу
    List<OrderItem> findByStatus(String status);

    // проверить, есть ли айтем у заказа с конкретным SKU
    boolean existsByOrder_IdAndSkuId(Long orderId, Integer skuId);

    // найти айтем по внешнему id (external_item_id)
    Optional<OrderItem> findByOrderItemId(Integer orderItemId);

    // найти айтемы дороже определённой цены
    List<OrderItem> findByFullPriceGreaterThan(BigDecimal minPrice);

    // найти айтемы дешевле определённой цены
    List<OrderItem> findByFullPriceLessThanEqual(BigDecimal maxPrice);

    // найти айтемы по рейтингу
    List<OrderItem> findByRatingGreaterThanEqual(Double rating);

    // найти все айтемы, которые редактируемые
    List<OrderItem> findByIsEditableTrue();
}
