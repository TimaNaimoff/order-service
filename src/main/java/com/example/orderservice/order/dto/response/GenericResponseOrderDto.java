package com.example.orderservice.order.dto.response;

import com.example.orderservice.dto.response.ApiErrorResponse;
import com.example.orderservice.dto.response.GenericResponseObject;
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
