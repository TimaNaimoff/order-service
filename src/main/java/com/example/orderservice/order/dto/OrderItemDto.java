package com.example.orderservice.order.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private Integer amount;
    private Integer returnedAmount;
    private Integer amountAvailable;
    private Object characteristics;
    private List<Object> skuCharacteristics;
    private Integer fullPrice;
    private Long id;
    private Integer orderItemId;
    private Integer ownRating;
    private PhotoDto photo;
    private String image;
    private Integer purchasePrice;
    private Integer paymentPrice;
    private Double rating;
    private Integer skuId;
    private String status;
    private StatusDto statusDto;
    private String title;
    private Boolean isEditable;
    private LocalDateTime dateBought;
    private String sellerTitle;
    private Boolean hasVerticalPhoto;

}