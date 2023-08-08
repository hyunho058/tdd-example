package com.example.tddexample.kiosk.unit.spring.api.presentation.product.response;

import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import lombok.Getter;

@Getter
public class ProductResponse {
    private final Long id;
    private final String productNumber;
    private final ProductType type;
    private final ProductSellingStatus sellingStatus;
    private final String name;
    private final int price;

    public ProductResponse(Product product) {
        this(
            product.getId(),
            product.getProductNumber(),
            product.getType(),
            product.getSellingStatus(),
            product.getName(),
            product.getPrice()
        );
    }

    public ProductResponse(Long id,
                           String productNumber,
                           ProductType type,
                           ProductSellingStatus sellingStatus,
                           String name,
                           int price) {
        this.id = id;
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }
}
