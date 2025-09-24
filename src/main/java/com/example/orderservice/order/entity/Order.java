package com.example.orderservice.order.entity;

import com.example.orderservice.common.entity.BonusProgram;
import com.example.orderservice.customer.entity.Customer;
import com.example.orderservice.delivery.entity.Delivery;
import com.example.orderservice.payment.entity.PaymentIntentionAction;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer commission;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer contacts;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime expectedDate;

    private LocalTime expectedDateFrom;
    private LocalTime expectedDateTo;

    private LocalDateTime storageUntil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private Delivery delivery;

    private Integer deliveryPrice;
    private Boolean eco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> items;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_discount_id", referencedColumnName = "id")
    private OrderDiscount orderDiscountDto;

    private Boolean isManualPickup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<PaymentIntentionAction> paymentIntentionActions;

    private String paymentType;
    private String paymentProvider;
    private String paymentUrl;
    private String promoCode;
    private Integer price;
    private Boolean notifyUserAboutEvents;
    private String returnUrl;
    private String sign;
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;


    private String cancellationAvailability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "used_promo_code_id", referencedColumnName = "id")
    private BonusProgram usedPromoCode;

    private Integer originalDeliveryPrice;
    private Integer dshopId;
    private Integer issueCode;

    private Integer headOrderId;
    private String type;
    private String carrierCode;
    private Boolean existDbsSubOrder;
    private Boolean ruPostDelivery;
    private Boolean postamatDelivery;

    @ElementCollection
    @CollectionTable(name = "order_payment_block_texts", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "text")
    private List<String> paymentBlockTexts;
}
