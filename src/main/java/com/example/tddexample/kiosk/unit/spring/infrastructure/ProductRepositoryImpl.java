package com.example.tddexample.kiosk.unit.spring.infrastructure;

import com.example.tddexample.kiosk.unit.spring.api.application.product.prot.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<ProductEntity> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypes) {
        return productJpaRepository.findAllBySellingStatusIn(sellingTypes);
    }

    @Override
    public List<ProductEntity> findAllByProductNumberIn(List<String> productNumbers) {
        return productJpaRepository.findAllByProductNumberIn(productNumbers);
    }

    @Override
    public String findLatestProduct() {
        return productJpaRepository.findLatestProduct();
    }
}
