package com.example.tddexample.kiosk.unit.spring.domain.product;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Product {
    private Long id;
    private String productNumber;
    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

    public Product(String productNumber,
                         ProductType type,
                         ProductSellingStatus sellingStatus,
                         String name,
                         int price) {
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }
}
