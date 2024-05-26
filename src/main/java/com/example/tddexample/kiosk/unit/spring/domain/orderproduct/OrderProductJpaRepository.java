package com.example.tddexample.kiosk.unit.spring.domain.orderproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderProductJpaRepository extends JpaRepository<OrderProductEntity, Long> {
}
