package com.example.tddexample.kiosk.unit.spring.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    @Query("select o from OrderEntity o where o.registeredDateTime >= :startDateTime" +
            " and o.registeredDateTime < :endDateTime" +
            " and o.orderStatus = :status")
    List<OrderEntity> findOrdersBy(
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            OrderStatus status
    );
}
