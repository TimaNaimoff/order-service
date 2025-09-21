package com.example.orderservice.entity;

import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // внутренний PK

    // внешний id позиции (если есть в API/внешней системе)
    @Column(name = "external_item_id")
    private Integer orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Integer skuId;
    private String title;

    private Integer amount;
    private Integer returnedAmount;
    private Integer amountAvailable;

    @Column(precision = 15, scale = 2)
    private BigDecimal fullPrice;

    @Column(precision = 15, scale = 2)
    private BigDecimal purchasePrice;

    @Column(precision = 15, scale = 2)
    private BigDecimal paymentPrice;

    private Integer ownRating;
    private Double rating;

    private String status;

    @Lob
    private String statusDto; // сериализованный JSON

    @Lob
    private String characteristics; // JSON строка

    @Lob
    private String skuCharacteristics; // JSON массив

    private Boolean isEditable;
    private LocalDateTime dateBought;

    private String sellerTitle;
    private Boolean hasVerticalPhoto;

    // если нужна отдельная таблица photo
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    private String image; // прямая ссылка на картинку
}
