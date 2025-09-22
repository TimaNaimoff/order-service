package com.example.orderservice.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "order_item_characteristics")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   // название характеристики (например "Цвет")
    private String value;   // значение (например "Красный")

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;
}
