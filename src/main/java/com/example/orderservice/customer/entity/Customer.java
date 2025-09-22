package com.example.orderservice.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone" , nullable = false)
    private String phone;
    @Column(name = "email" , nullable = false)
    private String email;
    @Column(name = "first_name" , nullable = false)
    private String firstName;
    @Column(name = "last_name" , nullable = false)
    private String lastName;
    @Column(name = "patronymic" , nullable = false)
    private String patronymic;
    @Column(name = "sex" , nullable = false)
    private String sex;
    @Column(name = "birth_date" , nullable = false)
    private LocalDate birthDate;

}
