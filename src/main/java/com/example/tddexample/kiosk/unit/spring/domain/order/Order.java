package com.example.tddexample.kiosk.unit.spring.domain.order;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProduct;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    private int totalPrice;

    private LocalDateTime registeredDateTime;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProduct = new ArrayList<>();

    protected Order() {
    }

    public Order(List<Product> products, LocalDateTime registeredDateTime) {
        this.orderStatus = OrderStatus.INIT;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
        this.orderProduct = products.stream()
            .map(product -> new OrderProduct(this, product))
            .collect(Collectors.toList());
    }

    public Order(OrderStatus orderStatus,
                 int totalPrice,
                 LocalDateTime registeredDateTime,
                 List<OrderProduct> orderProduct) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
        this.orderProduct = orderProduct;
    }

    private static int sumTotalPrice(List<Product> products) {
        return products.stream()
            .mapToInt(Product::getPrice)
            .sum();
    }
}
