package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.request.OrderCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.application.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.api.application.product.response.ProductResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final ProductRepository productRepository;
    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);

        Order order = new Order(products, registeredDateTime);

        return new OrderResponse(
            0L,
            1000,
            LocalDateTime.now(),
            new ArrayList<>()
        );
    }
}
