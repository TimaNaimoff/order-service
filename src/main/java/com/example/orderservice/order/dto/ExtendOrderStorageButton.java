package com.example.orderservice.order.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExtendOrderStorageButton {
    private String buttonText;
    private String backgroundTextColor;
    private String buttonTextColor;
    private ExtendOrderStorageButton modalWindow;
}
