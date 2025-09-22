package com.example.orderservice.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {
    private String period;
    private String date;
    private String address;
    private String apartment;
    private String entrance;
    private String floor;
    private String intercom;
    private String deliveryComment;
    private Boolean isTodayDelivery;
    private Integer deliveryPointId;
    private String schedule;
    private ScheduleInfoDto scheduleInfo;
    private Integer cityId;
    private Integer districtId;
    private Integer price;
    private Integer originalDeliveryPrice;
    private String deliveryType;
    private Integer deliveryOptionId;
    private String deliveryPointKey;
    private Integer zoneId;
    private Double longitude;
    private Double latitude;
    private String deliveryStatus;
    private String deliveryPointType;
    private List<String> deliveryDates;
    private Integer pickPointId;
    private Boolean ruPostDelivery;
    private Integer postamatId;
}
