package com.example.orderservice.order.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuDeliveryDate {
    private List<Integer> skuIds;
    private Integer deliveryOptionId;
    private LocalDate date;
}
