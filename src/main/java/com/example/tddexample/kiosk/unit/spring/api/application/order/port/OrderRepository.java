package com.example.tddexample.kiosk.unit.spring.api.application.order.port;

import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {
    void saveAll(List<Order> orders);

    Order save(Order order);

    List<Order> findOrdersBy(LocalDateTime startDateTime, LocalDateTime endDateTime, OrderStatus status);
}
