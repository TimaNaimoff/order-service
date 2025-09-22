package com.example.orderservice.delivery.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "day_schedule")
public class DayScheduleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private Boolean dayOff;

    private String workingHours;

    @ManyToOne
    @JoinColumn(name = "schedule_info_id")
    private ScheduleInfo scheduleInfo;
}
