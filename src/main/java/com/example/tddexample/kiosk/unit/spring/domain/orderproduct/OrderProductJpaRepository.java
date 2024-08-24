package com.example.tddexample.kiosk.unit.spring.domain.orderproduct;

import com.example.tddexample.kiosk.unit.spring.infrastructure.product.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductJpaRepository extends JpaRepository<OrderProductEntity, Long> {
}
