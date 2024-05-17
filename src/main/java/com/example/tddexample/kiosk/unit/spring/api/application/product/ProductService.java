package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.dto.ProductCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getSellingProducts();
    ProductResponse createProduct(ProductCreateServiceRequest request);
    ProductResponse getProduct(Long id);
}
