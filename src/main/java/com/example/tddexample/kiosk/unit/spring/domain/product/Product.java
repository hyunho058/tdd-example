package com.example.tddexample.kiosk.unit.spring.domain.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.dto.ProductCreateServiceRequest;
import lombok.Getter;

@Getter
public class Product {
    private final Long id;
    private final String productNumber;
    private final ProductType type;
    private final ProductSellingStatus sellingStatus;
    private final String name;
    private final int price;

    public static Product create(
            String productNumber,
            ProductType type,
            ProductSellingStatus sellingStatus,
            String name,
            int price
    ) {
        return new Product(null, productNumber, type, sellingStatus, name, price);
    }

    public Product(ProductCreateServiceRequest request, String nextProductNumber) {
        this(
                null,
                nextProductNumber,
                request.type(),
                request.sellingStatus(),
                request.name(),
                request.price()
        );
    }

    public Product(
            Long id,
            String productNumber,
            ProductType type,
            ProductSellingStatus sellingStatus,
            String name,
            int price
    ) {
        this.id = id;
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }
}
