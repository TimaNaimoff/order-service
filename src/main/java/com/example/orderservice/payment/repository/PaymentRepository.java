package com.example.orderservice.repository;

import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // найти все платежи по заказу
    List<Payment> findByOrder_Id(Long orderId);

    // найти все платежи по провайдеру
    List<Payment> findByProvider(String provider);

    // найти все платежи по типу (CARD, SBP, CASH)
    List<Payment> findByType(String type);

    // найти все платежи по статусу
    List<Payment> findByStatus(PaymentStatus status);

    // найти платеж по intentionId (уникальный идентификатор у провайдера)
    Optional<Payment> findByIntentionId(String intentionId);

    // проверить, есть ли успешный платеж по заказу
    boolean existsByOrder_IdAndStatus(Long orderId, PaymentStatus status);

    // найти все платежи выше определённой суммы
    List<Payment> findByAmountGreaterThan(BigDecimal amount);

    // найти все платежи в заданном интервале времени
    List<Payment> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    // найти последний платеж по заказу
    Optional<Payment> findFirstByOrder_IdOrderByCreatedAtDesc(Long orderId);
}
