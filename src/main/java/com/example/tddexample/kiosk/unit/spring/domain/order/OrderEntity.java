package com.example.tddexample.kiosk.unit.spring.domain.order;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductEntity;
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProductEntity> orderProductEntity = new ArrayList<>();

    protected OrderEntity() {
    }

    public OrderEntity(OrderStatus status, List<ProductEntity> products, LocalDateTime registeredDateTime) {
        this.orderStatus = status;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
        this.orderProductEntity = products.stream()
                .map(product -> new OrderProductEntity(this, product))
                .collect(Collectors.toList());
    }

    public OrderEntity(List<ProductEntity> products, LocalDateTime registeredDateTime) {
        this.orderStatus = OrderStatus.INIT;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
        this.orderProductEntity = products.stream()
            .map(product -> new OrderProductEntity(this, product))
            .collect(Collectors.toList());
    }

    public OrderEntity(OrderStatus orderStatus,
                       int totalPrice,
                       LocalDateTime registeredDateTime,
                       List<OrderProductEntity> orderProductEntity) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
        this.orderProductEntity = orderProductEntity;
    }

    private static int sumTotalPrice(List<ProductEntity> products) {
        return products.stream()
            .mapToInt(ProductEntity::getPrice)
            .sum();
    }
}
