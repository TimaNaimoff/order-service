package com.example.orderservice.order.repository;

import com.example.orderservice.order.entity.Order;
import com.example.orderservice.order.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // найти по статусу (enum)
    List<Order> findByOrderStatus(OrderStatus status);

    // найти по промокоду
    List<Order> findByPromoCode(String promoCode);

    // найти все, созданные после определённой даты
    List<Order> findByDateCreatedAfter(LocalDateTime dateTime);

    // найти все, обновлённые в определённом диапазоне
    List<Order> findByDateUpdatedBetween(LocalDateTime from, LocalDateTime to);

    // найти заказ по paymentUrl (уникальный кейс — например, для редиректа)
    Optional<Order> findByPaymentUrl(String paymentUrl);

    // проверить, есть ли заказ с указанным sign (часто sign используют как внешний идентификатор)
    boolean existsBySign(String sign);

    // найти заказы конкретного пользователя (по customer_id)
    List<Order> findByContacts_Id(Long customerId);

    // найти заказы по delivery id
    List<Order> findByDelivery_Id(Long deliveryId);

    // найти все заказы с определённым кодом выдачи
    List<Order> findByIssueCode(Integer issueCode);
}
