package com.example.orderservice.repository;

import com.example.orderservice.entity.DayScheduleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DayScheduleRepository extends JpaRepository<DayScheduleInfo,Long> {


    Optional<DayScheduleInfo> findByDay(String day);


    boolean existsByDayAndDayOffTrue(String day);


    List<DayScheduleInfo> findAllByScheduleInfoId(Long scheduleInfoId);


    List<DayScheduleInfo> findAllByScheduleInfoIdAndDayOffFalse(Long scheduleInfoId);
}
