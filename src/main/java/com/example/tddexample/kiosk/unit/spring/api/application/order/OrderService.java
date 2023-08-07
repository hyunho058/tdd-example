package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.request.OrderCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.application.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.productNumbers();
        Products products = new Products(productRepository.findAllByProductNumberIn(productNumbers));

        List<Product> duplicateProducts = products.productsWithDuplicates(productNumbers);

        Order newOrder = new Order(duplicateProducts, registeredDateTime);
        Order savedOrder = orderRepository.save(newOrder);

        return new OrderResponse(savedOrder, duplicateProducts);
    }
}
