package com.example.orderservice.order.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDiscountDto {
    private List<OrderBundleDto> bundles;
    private List<Integer>ids;
}
