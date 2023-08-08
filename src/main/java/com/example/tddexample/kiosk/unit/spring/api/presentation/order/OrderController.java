package com.example.tddexample.kiosk.unit.spring.api.presentation.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.OrderService;
import com.example.tddexample.kiosk.unit.spring.api.application.order.dto.OrderCreateServiceRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.request.OrderCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.comon.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/v1/orders/new")
    public ApiResponse<OrderResponse> createOrder(@Valid @RequestBody OrderCreateRequest request) {
        return new ApiResponse<>(
                HttpStatus.OK,
                orderService.createOrder(
                        request.toServiceRequest(),
                        LocalDateTime.now()
                )
        );
    }
}
