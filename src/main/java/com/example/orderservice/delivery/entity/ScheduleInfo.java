package com.example.orderservice.entity;


import com.example.orderservice.dto.DayScheduleInfoDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule_info")
public class ScheduleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "scheduleInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayScheduleInfoDto> days;
}
