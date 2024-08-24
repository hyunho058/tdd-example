package com.example.tddexample.kiosk.unit.spring.api.presentation.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.dto.OrderCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.response.OrderResponse;

import java.time.LocalDateTime;

public interface OrderService {
    OrderResponse createOrder(OrderCreateServiceRequest request, LocalDateTime registeredDateTime);
}
