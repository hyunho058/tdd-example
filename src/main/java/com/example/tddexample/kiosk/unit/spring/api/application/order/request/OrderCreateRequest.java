package com.example.tddexample.kiosk.unit.spring.api.application.order.request;

import java.util.List;

public record OrderCreateRequest(List<String> productNumbers) {
}
