package com.example.tddexample.kiosk.unit.spring.api.application.order.request;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderCreateRequest {
    private final List<String> productNumbers;

    public OrderCreateRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }
}
