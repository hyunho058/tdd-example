package com.example.tddexample.kiosk.unit.spring.api.application.product.dto;

import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductCreateServiceRequest(ProductType type,
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
