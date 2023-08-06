package com.example.tddexample.kiosk.unit.spring.domain.orderproduct;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class OrderProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    protected OrderProduct() {
    }

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
