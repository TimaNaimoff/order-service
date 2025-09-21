package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonusProgramDto {
    private Boolean ok;
    private Map<String , Object> localizableText;
    private Integer priceDelta;
    private String text;
}
