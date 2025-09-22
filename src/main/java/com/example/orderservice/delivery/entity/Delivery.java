package com.example.orderservice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String period;

    private String date;

    private String address;

    private String apartment;

    private String entrance;

    private String floor;

    private String intercom;

    @Column(name = "delivery_comment")
    private String deliveryComment;

    @Column(name = "is_today_delivery")
    private Boolean isTodayDelivery;

    @Column(name = "delivery_point_id")
    private Integer deliveryPointId;

    private String schedule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_info_id")
    private ScheduleInfo scheduleInfo;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "district_id")
    private Integer districtId;

    private Integer price;

    @Column(name = "original_delivery_price")
    private Integer originalDeliveryPrice;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "delivery_option_id")
    private Integer deliveryOptionId;

    @Column(name = "delivery_point_key")
    private String deliveryPointKey;

    @Column(name = "zone_id")
    private Integer zoneId;

    private Double longitude;

    private Double latitude;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    @Column(name = "delivery_point_type")
    private String deliveryPointType;

    @ElementCollection
    @CollectionTable(name = "delivery_dates", joinColumns = @JoinColumn(name = "delivery_id"))
    @Column(name = "delivery_date")
    private List<String> deliveryDates;

    @Column(name = "pick_point_id")
    private Integer pickPointId;

    @Column(name = "ru_post_delivery")
    private Boolean ruPostDelivery;

    @Column(name = "postamat_id")
    private Integer postamatId;

}
