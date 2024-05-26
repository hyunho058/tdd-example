package com.example.tddexample.kiosk.unit.spring.domain.product;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class Products {
    private final List<ProductEntity> products;

    public Products(List<ProductEntity> products) {
        this.products = products;
    }

    public List<ProductEntity> productsWithDuplicates(List<String> productNumbers) {
        Map<String, ProductEntity> productMap = products.stream()
                .collect(Collectors.toMap(ProductEntity::getProductNumber, p -> p));

        return productNumbers.stream()
                .map(productMap::get).collect(Collectors.toList());
    }

    public List<String> containProductNumberType() {
        return products.stream()
                .filter(product -> ProductType.containsStockType(product.getType()))
                .map(ProductEntity::getProductNumber)
                .collect(Collectors.toList());
    }

}
