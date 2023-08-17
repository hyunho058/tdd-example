package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductNumberFactory {
    private final ProductRepository productRepository;

    public String createProductNumber() {
        String latestProductNumber = productRepository.findLatestProduct();

        if (latestProductNumber == null) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        return String.format("%03d", nextProductNumberInt);
    }
}
