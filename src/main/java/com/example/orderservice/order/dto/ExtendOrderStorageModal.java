package com.example.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExtendOrderStorageModal {
    private String modalTitle;
    private String modalText;
    private String buttonText;
    private String buttonBackgroundColor;
    private String toastMessageText;
}
