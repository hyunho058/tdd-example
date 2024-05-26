package com.example.tddexample.kiosk.unit.spring.domain.order;

import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProduct;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProductEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private OrderStatus orderStatus;
    private int totalPrice;
    private LocalDateTime registeredDateTime;
    private List<OrderProduct> orderProducts = new ArrayList<>();


}
