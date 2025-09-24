package com.example.orderservice.order.service;


import com.example.orderservice.common.mapper.BonusProgramMapper;
import com.example.orderservice.common.mapper.PhotoMapper;
import com.example.orderservice.common.service.CommonService;
import com.example.orderservice.customer.mapper.CustomerMapper;
import com.example.orderservice.customer.service.CustomerService;
import com.example.orderservice.delivery.service.DeliveryService;
import com.example.orderservice.exception.InvalidCustomerException;
import com.example.orderservice.exception.InvalidOrderException;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.order.dto.OrderDto;
import com.example.orderservice.order.entity.Order;
import com.example.orderservice.order.entity.OrderDiscount;
import com.example.orderservice.order.entity.OrderItem;
import com.example.orderservice.order.entity.OrderStatus;
import com.example.orderservice.order.mapper.*;
import com.example.orderservice.order.repository.*;
import com.example.orderservice.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final CommonService commonService;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;


    private final OrderRepository orderRepository;

    private final OrderStatusMapper orderStatusMapper;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final BonusProgramMapper bonusProgramMapper;
    private final PhotoMapper photoMapper;

    @Transactional(readOnly = true)
    public OrderDto getOrderById(Long orderId){
        log.info("Fetching order with id={}",orderId);
        Order order= orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException(orderId));

        return orderMapper.toDto(order);
    }

    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("Creating new order");

        if (orderDto.getContacts() == null || orderDto.getContacts().getEmail() == null) {
            throw new InvalidCustomerException("Customer contacts are required");
        }

        var customer = customerService.getCustomerByEmail(
                orderDto.getContacts().getEmail(),
                orderDto.getContacts().getPhone()
        );

        Order order = orderMapper.toEntity(orderDto);
        order.setContacts(customerMapper.toEntity(customer));
        order.setDateCreated(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.CREATED); // начальный статус
        order.setStatus(orderStatusMapper.toDto(OrderStatus.CREATED).getValue());

        if (orderDto.getPromoCode() != null) {
            var promoOpt = commonService.getBonusProgramByText(orderDto.getPromoCode());
            promoOpt.ifPresent(dto -> order.setUsedPromoCode(bonusProgramMapper.toEntity(dto)));
        }

        if (order.getItems() != null) {
            order.getItems().forEach(item -> {
                if (item.getPhoto() != null && item.getPhoto() != null) {
                    commonService.getPhotoByKey(item.getPhoto().getPhotoKey())
                            .ifPresent(photoDto -> item.setPhoto(photoMapper.toEntity(photoDto)));
                }
            });
        }

        Order savedOrder = orderRepository.save(order);

        if (orderDto.getDelivery() != null) {
            deliveryService.assignDelivery(savedOrder.getId(), orderDto.getDelivery());
        }

        if (orderDto.getPrice() != null && orderDto.getPaymentProvider() != null && orderDto.getPaymentType() != null) {
            paymentService.createPayment(
                    savedOrder,
                    BigDecimal.valueOf(orderDto.getPrice()),
                    orderDto.getPaymentProvider(),
                    orderDto.getPaymentType()
            );
        }

        log.info("Order created successfully with id={}", savedOrder.getId());

        return orderMapper.toDto(savedOrder);
    }

    @Transactional
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        log.info("Updating order id={} with data={}", orderId, orderDto);

        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        if (existingOrder.getOrderStatus() != OrderStatus.CREATED) {
            throw new InvalidOrderException(
                    String.format(
                            "Order [%d] cannot be updated. Allowed status: %s, current status: %s",
                            orderId,
                            OrderStatus.CREATED,
                            existingOrder.getOrderStatus()
                    )
            );
        }

        orderMapper.updateEntity(orderDto, existingOrder);
        existingOrder.setDateUpdated(LocalDateTime.now());

        Order saved = orderRepository.save(existingOrder);
        return orderMapper.toDto(saved);
    }

    @Transactional
    public OrderDto updateOrderStatus(Long orderId, OrderStatus status) {
        log.info("Updating order status. orderId={}, newStatus={}", orderId, status);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        if (!order.getOrderStatus().canTransitionTo(status)) {
            throw new InvalidOrderException("Invalid status transition from " + order.getStatus() + " to " + status);
        }

        order.setOrderStatus(status);
        order.setDateUpdated(LocalDateTime.now());

        return orderMapper.toDto(orderRepository.save(order));
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        log.info("Deleting order id={}", orderId);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        if (!order.getOrderStatus().equals(OrderStatus.CANCELLED)) {
            throw new InvalidOrderException("Order cannot be deleted in current status: " + order.getStatus());
        }

        orderRepository.delete(order);
        log.info("Order deleted successfully. id={}", orderId);
    }







}
