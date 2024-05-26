package com.example.tddexample.kiosk.unit.spring.api.application.order.prot;

import com.example.tddexample.kiosk.unit.spring.domain.order.OrderEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {
    List<OrderEntity> findOrdersBy(LocalDateTime startDateTime, LocalDateTime endDateTime, OrderStatus status);
}
