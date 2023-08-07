package com.example.tddexample.kiosk.unit.spring.api.presentation.product.request;

import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;

public record ProductCreateRequest(ProductType type,
                                   ProductSellingStatus sellingStatus,
                                   String name,
                                   int price) {
    public Product toEntity(String nextProductNumber) {
        return new Product(
            nextProductNumber,
            this.type(),
            this.sellingStatus(),
            this.name(),
            this.price());
    }
}
