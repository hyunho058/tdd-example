package com.example.tddexample.kiosk.unit.spring.api.application.product.dto;

import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;

public record ProductCreateServiceRequest(
        ProductType type,
        ProductSellingStatus sellingStatus,
        String name,
        int price
) {
}
