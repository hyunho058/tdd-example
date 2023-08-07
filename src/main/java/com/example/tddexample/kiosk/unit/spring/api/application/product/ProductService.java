package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
            .map(ProductResponse::new)
            .collect(Collectors.toList());
    }

    public void createProduct(ProductCreateRequest request) {
        //productNumber
        //001, 002, 003
        //DB에서 마지막 저장된 product의 상품번호 조회해서 +1
        productRepository.findLatestProduct();
    }
}
