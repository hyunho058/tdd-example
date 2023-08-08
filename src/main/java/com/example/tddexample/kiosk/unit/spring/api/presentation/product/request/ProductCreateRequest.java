package com.example.tddexample.kiosk.unit.spring.api.presentation.product.request;

import com.example.tddexample.kiosk.unit.spring.api.application.product.dto.ProductCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductCreateRequest(@NotNull(message = "상품 타입은 필수입니다.") ProductType type,
                                   @NotNull(message = "상품 판매상태는 필수입니다.") ProductSellingStatus sellingStatus,
                                   @NotBlank(message = "상품 이름은 필수입니다.") String name,
                                   @Positive(message = "상품 가격은 양수입니다.") int price) {

    public ProductCreateServiceRequest toServiceRequest() {
        return new ProductCreateServiceRequest(
                this.type,
                this.sellingStatus,
                this.name,
                this.price
        );
    }
}
