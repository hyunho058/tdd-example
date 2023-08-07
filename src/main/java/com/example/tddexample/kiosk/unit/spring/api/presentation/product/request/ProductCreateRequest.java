package com.example.tddexample.kiosk.unit.spring.api.presentation.product.request;

import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;

public record ProductCreateRequest(String productNumber,
                                   ProductSellingStatus sellingStatus,
                                   String name,
                                   int price) {
}
