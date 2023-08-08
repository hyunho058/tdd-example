package com.example.tddexample.kiosk.unit.spring.api.application.order.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderCreateServiceRequest(List<String> productNumbers) {
}
