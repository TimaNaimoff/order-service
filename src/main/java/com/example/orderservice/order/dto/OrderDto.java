package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer commission;
    private CustomerContactsDto contacts;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime expectedDate;
    private LocalTime expectedDateFrom;
    private LocalTime expectedDateTo;
    private LocalDateTime storageUntil;
    private DeliveryDto delivery;
    private Integer deliveryPrice;
    private Boolean eco;
    private List<OrderItemDto> items;
    private OrderDiscountDto orderDiscountDto;
    private Boolean isManualPickup;
    private List<PaymentIntentionActionDto> paymentIntentionActionDtos;
    private Long id;
    private String paymentType;
    private String paymentProvider;
    private String paymentUrl;
    private String promoCode;
    private Integer price;
    private Boolean notifyUserAboutEvents;
    private String returnUrl;
    private String sign;
    private String status;
    private OrderStatusDto orderStatusDto;
    private String cancellationAvailability;
    private BonusProgramDto usedPromoCode;
    private Integer originalDeliveryPrice;
    private Integer dshopId;
    private Integer issueCode;
    private ExtendOrderStorageButton extendOrderStorageButton;
    private Integer headOrderId;
    private String type;
    private String carrierCode;
    private String cancellationButtonName;
    private Boolean existDbsSubOrder;
    private InfoBannerDto infoBanner;
    private Boolean ruPostDelivery;
    private Boolean postamatDelivery;
    private String click_id;
    private List<String> payment_block_texts;
    private List<InstallmentButtonDto> installment_button;

}