package com.example.orderservice.payment.repository;

import com.example.orderservice.payment.entity.Payment;
import com.example.orderservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByIntentionId(String intentionId);

    List<Payment> findAllByOrder(Order order);

    Optional<Payment> findFirstByOrderOrderByCreatedAtDesc(Order order);
}
