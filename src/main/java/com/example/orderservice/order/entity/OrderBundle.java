package com.example.orderservice.order.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "order_bundles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBundle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderBundle")
    private List<OrderItem> items;
}
