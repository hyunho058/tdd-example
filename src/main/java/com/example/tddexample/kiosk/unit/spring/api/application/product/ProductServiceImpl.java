package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.dto.ProductCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.application.product.port.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
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
    private final ProductRepository productRepository;
    private final ProductNumberFactoryImpl productNumberFactoryImpl;

    @Override
    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = productNumberFactoryImpl.createProductNumber();

        Product newProduct = new Product(request, nextProductNumber);
        Product savedProduct = productRepository.save(newProduct);

        return new ProductResponse(savedProduct);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));

        return new ProductResponse(product);
    }
}
