package com.example.tddexample.kiosk.unit.spring.domain.orderproduct;

import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;

public class OrderProduct {
    private Long id;
    private Order order;
    private Product product;

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
