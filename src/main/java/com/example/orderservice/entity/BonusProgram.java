package com.example.orderservice.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "bonus_program")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonusProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_ok",nullable = false)
    private Boolean ok;
    @Column(name = "localizable_text", columnDefinition = "jsonb")
    private String localizableText;
    @Column(name="price_delta" , nullable = false)
    private Integer priceDelta;
    @Column(name = "text")
    private String text;

}
