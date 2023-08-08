package com.example.tddexample.kiosk.unit.spring.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select o from Orders o where o.registeredDateTime > :startDateTime and o.registeredDateTime < :endDateTime and o.orderStatus = :status", nativeQuery = true)
    List<Order> findOrderBy(
            @Param("startDateTime") LocalDateTime startDateTime,
            @Param("endDateTime") LocalDateTime endDateTime,
            @Param("status") OrderStatus status);
}
