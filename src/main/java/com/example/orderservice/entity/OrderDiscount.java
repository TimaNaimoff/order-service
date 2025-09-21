package com.example.orderservice.entity;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "order_discounts")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // связь с заказом
    @OneToOne(mappedBy = "orderDiscountDto")
    private Order order;

    // связи на бандлы
    @OneToMany(mappedBy = "orderDiscount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderBundle> bundles = new ArrayList<>();

    // список id скидок — можно хранить в отдельной таблице
    @ElementCollection
    @CollectionTable(
            name = "order_discount_ids",
            joinColumns = @JoinColumn(name = "order_discount_id")
    )
    @Column(name = "discount_id")
    private List<Integer> ids = new ArrayList<>();
}
