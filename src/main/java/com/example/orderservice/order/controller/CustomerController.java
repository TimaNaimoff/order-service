package com.example.orderservice.order.controller;

import com.example.orderservice.common.dto.response.GenericResponseObject;
import com.example.orderservice.order.dto.OrderDto;
import com.example.orderservice.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user/order")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final OrderService orderService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public GenericResponseObject<OrderDto> gerOrderById(@RequestParam
                                                                        Long orderId){
        OrderDto orderDto = orderService.getOrderById(orderId);
        return GenericResponseObject.<OrderDto>builder().payload(orderDto)
                .errors(null).timestamp(LocalDateTime.now().toString()).build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public GenericResponseObject<OrderDto>createOrder(@RequestBody OrderDto orderDto){
        OrderDto createOrderDto = orderService.createOrder(orderDto);
        return GenericResponseObject.<OrderDto>builder().payload(createOrderDto)
                .errors(null).timestamp(LocalDateTime.now().toString()).build();
    }
}
