package com.example.tddexample.kiosk.unit.spring.infrastructure.product;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;
import com.example.tddexample.kiosk.unit.spring.infrastructure.order.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Table(name = "orders")
@Entity
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    private int totalPrice;

    private LocalDateTime registeredDateTime;

    protected OrderEntity() {
    }

    public OrderEntity(OrderStatus status, List<ProductEntity> products, LocalDateTime registeredDateTime) {
        this.orderStatus = status;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
    }

    public OrderEntity(List<ProductEntity> products, LocalDateTime registeredDateTime) {
        this.orderStatus = OrderStatus.INIT;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
    }

    public OrderEntity(
            OrderStatus orderStatus,
            int totalPrice,
            LocalDateTime registeredDateTime
    ) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
    }

    private static int sumTotalPrice(List<ProductEntity> products) {
        return products.stream()
                .mapToInt(ProductEntity::getPrice)
                .sum();
    }

    public static OrderEntity fromModel(Order order) {
        return new OrderEntity(
                order.getOrderStatus(),
                order.getTotalPrice(),
                order.getRegisteredDateTime()
        );
    }

    public Order toModel() {
        return Order.create(
                orderStatus,
                totalPrice,
                registeredDateTime
        );
    }
}
