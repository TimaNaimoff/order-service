package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDiscountRepository extends JpaRepository<OrderDiscount, Long> {

    // Найти скидку по id заказа
    Optional<OrderDiscount> findByOrder_Id(Long orderId);

    // Найти все скидки, в которых есть указанный discountId в списке ids
    List<OrderDiscount> findByIdsContains(Integer discountId);

    // Проверить, есть ли скидка с таким discountId
    boolean existsByIdsContains(Integer discountId);

    // Найти все скидки, в которых больше N бандлов
    List<OrderDiscount> findByBundles_SizeGreaterThan(int size);
}
