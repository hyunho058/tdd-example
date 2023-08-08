package com.example.tddexample.kiosk.unit.spring.api.application.order.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderCreateRequest(
        @NotEmpty(message = "상품 번호 리스트는 필수입니다.")
        List<String> productNumbers) {
}
