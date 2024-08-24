package com.example.tddexample.kiosk.unit.spring.domain.orderproduct;

import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import lombok.Getter;

@Getter
public class OrderProduct {
    private final Long id;
    private final Order order;
    private final Product product;

    public static OrderProduct create(Order order, Product product) {
        return new OrderProduct(null, order, product);

    }

    public OrderProduct(
            Long id,
            Order order,
            Product product
    ) {
        this.id = id;
        this.order = order;
        this.product = product;
    }
}
