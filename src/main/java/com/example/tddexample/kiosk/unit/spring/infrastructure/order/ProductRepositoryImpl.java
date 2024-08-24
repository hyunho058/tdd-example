package com.example.tddexample.kiosk.unit.spring.infrastructure.order;

import com.example.tddexample.kiosk.unit.spring.api.application.product.port.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productJpaRepository.saveAll(
                products.stream()
                        .map(ProductEntity::fromModel)
                        .toList()
        ).stream().map(ProductEntity::toModel).toList();
    }

    @Override
    public List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypes) {
        return productJpaRepository.findAllBySellingStatusIn(sellingTypes)
                .stream()
                .map(ProductEntity::toModel)
                .toList();
    }

    @Override
    public List<Product> findAllByProductNumberIn(List<String> productNumbers) {
        return productJpaRepository.findAllByProductNumberIn(productNumbers)
                .stream()
                .map(ProductEntity::toModel)
                .toList();
    }

    @Override
    public String findLatestProduct() {
        return productJpaRepository.findLatestProduct();
    }

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(ProductEntity.fromModel(product))
                .toModel();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id)
                .map(ProductEntity::toModel);
    }
}
