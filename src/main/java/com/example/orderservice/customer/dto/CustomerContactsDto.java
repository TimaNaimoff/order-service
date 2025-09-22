package com.example.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerContactsDto {
    private String phone;
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String sex;
    private String birthDate;
}
