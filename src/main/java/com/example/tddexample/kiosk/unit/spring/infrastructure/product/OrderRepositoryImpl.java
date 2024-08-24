package com.example.tddexample.kiosk.unit.spring.infrastructure.product;

import com.example.tddexample.kiosk.unit.spring.api.application.order.port.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
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
    public void saveAll(List<Order> orders) {
        orderJpaRepository.saveAll(
                orders.stream()
                        .map(OrderEntity::fromModel)
                        .toList()
        ).stream().map(OrderEntity::toModel).toList();
    }

    @Override
    public Order save(Order order) {
        return orderJpaRepository.save(OrderEntity.fromModel(order)).toModel();
    }

    @Override
    public List<Order> findOrdersBy(LocalDateTime startDateTime, LocalDateTime endDateTime, OrderStatus status) {
        List<OrderEntity> ordersBy = orderJpaRepository.findOrdersBy(startDateTime, endDateTime, status);

        return ordersBy.stream()
                .map(OrderEntity::toModel).toList();
    }
}
