package com.example.orderservice.exception;

import com.example.orderservice.common.dto.response.ApiErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseServiceException.class)
    public ResponseEntity<ApiErrorResponse> handleServiceException(BaseServiceException ex) {
        log.warn("{}: {}", ex.getCode(), ex.getMessage());
        ApiErrorResponse response = ApiErrorResponse.builder()
                .message(ex.getMessage())
                .code(ex.getCode())
                .build();
        // Можно по коду определить статус, или все BAD_REQUEST
        HttpStatus status = switch (ex.getCode()) {
            case "ORDER_NOT_FOUND", "CUSTOMER_NOT_FOUND", "DELIVERY_NOT_FOUND" -> HttpStatus.NOT_FOUND;
            case "PAYMENT_FAILED" -> HttpStatus.UNPROCESSABLE_ENTITY;
            case "DELIVERY_UNAVAILABLE" -> HttpStatus.CONFLICT;
            default -> HttpStatus.BAD_REQUEST;
        };
        return ResponseEntity.status(status).body(response);
    }

}
