package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderBundle;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface OrderBundleRepository extends JpaRepository<OrderBundle, Long> {

    List<OrderBundle> findByAmount(Integer amount);

    List<OrderBundle> findByAmountGreaterThan(Integer amount);

    List<OrderBundle> findByAmountLessThanEqual(Integer amount);

    Optional<OrderBundle> findFirstByAmount(Integer amount);

    boolean existsByAmount(Integer amount);
}
