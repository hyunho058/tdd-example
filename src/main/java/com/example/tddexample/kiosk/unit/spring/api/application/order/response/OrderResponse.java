package com.example.tddexample.kiosk.unit.spring.api.application.order.response;


import com.example.tddexample.kiosk.unit.spring.api.application.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderResponse {
    private final Long id;
    private final int totalPrice;
    private final LocalDateTime registeredDateTime;
    private final List<ProductResponse> products;

    public OrderResponse (Order order, List<Product> products) {
        this(
                order.getId(),
                order.getTotalPrice(),
                order.getRegisteredDateTime(),
                products.stream()
                        .map(ProductResponse::new)
                        .collect(Collectors.toList())
        );
    }

    public OrderResponse(Long id,
                         int totalPrice,
                         LocalDateTime registeredDateTime,
                         List<ProductResponse> products) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
        this.products = products;
    }
}
