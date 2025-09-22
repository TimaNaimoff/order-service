package com.example.orderservice.common.repository;

import com.example.orderservice.common.entity.BonusProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BonusProgramRepository extends JpaRepository<BonusProgram, Long> {


    boolean existsByText(String text);

    Optional<BonusProgram> findByText(String text);

    List<BonusProgram> findAllByOkTrue();
}
