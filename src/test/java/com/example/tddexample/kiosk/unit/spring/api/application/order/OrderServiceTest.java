package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.api.application.order.request.OrderCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.application.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@ActiveProfiles("test")
@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;

    @AfterEach
    void tearDown() {
        orderProductRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
        orderRepository.deleteAllInBatch();
    }

    @DisplayName("주문번호 리스트를 받아 주문을 생성한다.")
    @Test
    void createOrder() {
        //give
        Product product1 = createProduct("001", ProductType.HANDMADE, 4000);
        Product product2 = createProduct("002", ProductType.HANDMADE, 4500);
        Product product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productRepository.saveAll(List.of(product1, product2, product3));

        OrderCreateRequest request = new OrderCreateRequest(List.of("001", "002"));
        LocalDateTime nowDateTine = LocalDateTime.now();
        //when
        OrderResponse orderResponse = orderService.createOrder(request, nowDateTine);

        //then
        assertThat(orderResponse.getId()).isNotNull();
        assertThat(orderResponse)
            .extracting("registeredDateTime", "totalPrice")
            .contains(nowDateTine, 8500);
        assertThat(orderResponse.getProducts()).hasSize(2)
            .extracting("productNumber", "price")
            .containsExactlyInAnyOrder(
                tuple("001", 4000),
                tuple("002", 4500)
            );
    }

    @DisplayName("중복되는 상품번호 리스트로 주문을 생성할 수 있다.")
    @Test
    void createOrderWithDuplicateProductNumber() {
        //give
        Product product1 = createProduct("001", ProductType.HANDMADE, 4000);
        Product product2 = createProduct("002", ProductType.HANDMADE, 4500);
        Product product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productRepository.saveAll(List.of(product1, product2, product3));

        OrderCreateRequest request = new OrderCreateRequest(List.of("001", "001"));
        LocalDateTime nowDateTine = LocalDateTime.now();
        //when
        OrderResponse orderResponse = orderService.createOrder(request, nowDateTine);

        //then
        assertThat(orderResponse.getId()).isNotNull();
        assertThat(orderResponse)
                .extracting("registeredDateTime", "totalPrice")
                .contains(nowDateTine, 8000);
        assertThat(orderResponse.getProducts()).hasSize(2)
                .extracting("productNumber", "price")
                .containsExactlyInAnyOrder(
                        tuple("001", 4000),
                        tuple("001", 4000)
                );
    }

    private Product createProduct(String productNumber, ProductType type, int price) {
        return new Product(
            productNumber,
            type,
            ProductSellingStatus.SELLING,
            "상품 이름",
            price
        );
    }
}
