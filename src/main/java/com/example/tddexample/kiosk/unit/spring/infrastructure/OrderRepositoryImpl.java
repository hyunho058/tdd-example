package com.example.tddexample.kiosk.unit.spring.infrastructure;

import com.example.tddexample.kiosk.unit.spring.api.application.order.prot.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public List<OrderEntity> findOrdersBy(LocalDateTime startDateTime, LocalDateTime endDateTime, OrderStatus status) {
        return orderJpaRepository.findOrdersBy(startDateTime, endDateTime, status);
    }
}
