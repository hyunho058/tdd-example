package com.example.tddexample.kiosk.unit.spring.api.presentation.order.request;

import com.example.tddexample.kiosk.unit.spring.api.application.order.dto.OrderCreateServiceRequest;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderCreateRequest(
        @NotEmpty(message = "상품 번호 리스트는 필수입니다.")
        List<String> productNumbers) {

    public OrderCreateServiceRequest toServiceRequest() {
        return new OrderCreateServiceRequest(this.productNumbers);
    }

}
