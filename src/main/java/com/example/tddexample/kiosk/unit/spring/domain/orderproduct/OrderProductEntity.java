package com.example.tddexample.kiosk.unit.spring.domain.orderproduct;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "order_product")
@Entity
public class OrderProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    protected OrderProductEntity() {
    }

    public OrderProductEntity(OrderEntity order, ProductEntity product) {
        this.order = order;
        this.product = product;
    }
}
