package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.api.application.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.api.presentation.product.request.ProductCreateRequest;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
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

    @Transactional
    public ProductResponse createProduct(ProductCreateRequest request) {
        //productNumber
        //001, 002, 003
        //DB에서 마지막 저장된 product의 상품번호 조회해서 +1
        String latestProductNumber = productRepository.findLatestProduct();

        String nextProductNumber = createProductNumber(latestProductNumber);

        Product newProduct = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(newProduct);

        return new ProductResponse(savedProduct);
    }

    private String createProductNumber(String latestProductNumber) {
        if (latestProductNumber == null){
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;
        return String.format("%03d", nextProductNumberInt);
    }
}
