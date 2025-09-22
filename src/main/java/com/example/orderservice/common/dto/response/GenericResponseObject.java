package com.example.orderservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseObject<T> {
    private T payload;
    private List<ApiErrorResponse> errofs;
    private String timestamp;
    private String trace;
    private String error;
}
