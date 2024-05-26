package com.example.tddexample.kiosk.unit.spring.infrastructure;

import com.example.tddexample.kiosk.unit.spring.api.application.order.prot.OrderProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductJpaRepository orderProductJpaRepository;
}
