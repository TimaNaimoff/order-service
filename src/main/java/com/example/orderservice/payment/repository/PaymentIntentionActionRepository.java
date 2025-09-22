package com.example.orderservice.payment.repository;

import com.example.orderservice.payment.entity.PaymentIntentionAction;
import com.example.orderservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentIntentionActionRepository extends JpaRepository<PaymentIntentionAction, Long> {

    List<PaymentIntentionAction> findAllByOrder(Order order);
}
