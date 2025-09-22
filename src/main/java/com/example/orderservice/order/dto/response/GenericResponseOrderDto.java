package com.example.orderservice.dto;

import com.example.orderservice.dto.response.ApiErrorResponse;
import com.example.orderservice.dto.response.GenericResponseObject;
import com.example.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseOrderDto  {
    private OrderDto payload;
    private List<ApiErrorResponse> errors;
    private String timestamp;
    private String trace;
    private String error;
}
