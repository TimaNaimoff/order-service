    package com.example.orderservice.payment.entity;

    import javax.persistence.*;

    import com.example.orderservice.order.entity.Order;
    import lombok.*;

    @Entity
    @Table(name = "payment_intention_actions")
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class PaymentIntentionAction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id; // первичный ключ для базы

        private Integer intentionId; // как в DTO
        private String type;
        private String title;

        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order; // связь с заказом
    }
