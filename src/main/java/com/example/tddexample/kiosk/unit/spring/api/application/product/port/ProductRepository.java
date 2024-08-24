package com.example.tddexample.kiosk.unit.spring.api.application.product.port;

import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> saveAll(List<Product> products);

    List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypes);

    List<Product> findAllByProductNumberIn(List<String> productNumbers);

    String findLatestProduct();

    Product save(Product product);

    Optional<Product> findById(Long id);
}
