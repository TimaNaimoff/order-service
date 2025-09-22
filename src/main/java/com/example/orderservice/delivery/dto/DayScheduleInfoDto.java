package com.example.orderservice.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayScheduleInfoDto {
    private String day;
    private Boolean dayOff;
    private String workingHours;
}
