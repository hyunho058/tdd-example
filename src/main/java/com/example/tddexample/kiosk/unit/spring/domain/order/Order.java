package com.example.tddexample.kiosk.unit.spring.domain.order;

import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProduct;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Order {
    private final Long id;
    private final OrderStatus orderStatus;
    private final int totalPrice;
    private final LocalDateTime registeredDateTime;
//    private final List<OrderProduct> orderProducts;

    public static Order create(
            OrderStatus orderStatus,
            int totalPrice,
            LocalDateTime registeredDateTime
//            List<OrderProduct> orderProducts
    ) {
        return new Order(orderStatus, totalPrice, registeredDateTime);
    }

    public Order(OrderStatus status, List<Product> products, LocalDateTime registeredDateTime) {
        this.id = null;
        this.orderStatus = status;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
//        this.orderProducts = products.stream()
//                .map(product -> OrderProduct.create(this, product))
//                .collect(Collectors.toList());
    }

    public Order(List<Product> products, LocalDateTime registeredDateTime) {
        this.id = null;
        this.orderStatus = OrderStatus.INIT;
        this.totalPrice = sumTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
//        this.orderProducts = products.stream()
//                .map(product -> OrderProduct.create(this, product))
//                .collect(Collectors.toList());
    }

    public Order(
            OrderStatus orderStatus,
            int totalPrice,
            LocalDateTime registeredDateTime
//            List<OrderProduct> OrderProducts
    ) {
        this.id = null;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
//        this.orderProducts = OrderProducts;
    }

    public Order(
            Long id,
            OrderStatus orderStatus,
            int totalPrice,
            LocalDateTime registeredDateTime
//            List<OrderProduct> orderProducts
    ) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
//        this.orderProducts = orderProducts;
    }


    private static int sumTotalPrice(List<Product> products) {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }
}
