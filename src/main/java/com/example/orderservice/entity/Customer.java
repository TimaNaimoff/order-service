package com.example.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;

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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String birthDate;

}
