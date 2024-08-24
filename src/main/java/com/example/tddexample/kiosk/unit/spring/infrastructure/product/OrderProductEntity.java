package com.example.tddexample.kiosk.unit.spring.infrastructure.product;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProduct;
import com.example.tddexample.kiosk.unit.spring.infrastructure.order.ProductEntity;
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
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;

    protected OrderProductEntity() {
    }

    public OrderProductEntity(OrderEntity orderEntity, ProductEntity productEntity) {
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
    }

    public static OrderProductEntity fromModel(OrderProduct orderProduct) {
        return new OrderProductEntity(
                OrderEntity.fromModel(orderProduct.getOrder()),
                ProductEntity.fromModel(orderProduct.getProduct())
        );
    }

    public OrderProduct toModel() {
        return OrderProduct.create(orderEntity.toModel(), productEntity.toModel());
    }
}
