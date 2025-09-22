package com.example.orderservice.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    private Object photo;
    private String photoKey;
    private String color;
    private Boolean hasVerticalPhoto;
}
