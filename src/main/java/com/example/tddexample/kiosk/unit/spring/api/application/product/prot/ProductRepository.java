package com.example.tddexample.kiosk.unit.spring.api.application.product.prot;

import com.example.tddexample.kiosk.unit.spring.domain.product.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository {
    List<ProductEntity> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypes);
    List<ProductEntity> findAllByProductNumberIn(List<String> productNumbers);
    String findLatestProduct();
}
