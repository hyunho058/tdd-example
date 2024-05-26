package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.dto.ProductCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductJpaRepository productJPARepository;
    private final ProductNumberFactoryImpl productNumberFactoryImpl;


    @Override
    public List<ProductResponse> getSellingProducts() {
        List<ProductEntity> products = productJPARepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = productNumberFactoryImpl.createProductNumber();


        ProductEntity newProduct = request.toEntity(nextProductNumber);
        ProductEntity savedProduct = productJPARepository.save(newProduct);

        return new ProductResponse(savedProduct);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        ProductEntity product = productJPARepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));

        return new ProductResponse(product);
    }
}
