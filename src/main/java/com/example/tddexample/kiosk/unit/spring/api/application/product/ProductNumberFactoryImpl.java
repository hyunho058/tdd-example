package com.example.tddexample.kiosk.unit.spring.api.application.product;

import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductNumberFactoryImpl implements ProductNumberFactory {
    private final ProductJpaRepository productJPARepository;

    public String createProductNumber() {
        String latestProductNumber = productJPARepository.findLatestProduct();

        if (latestProductNumber == null) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        return String.format("%03d", nextProductNumberInt);
    }
}
