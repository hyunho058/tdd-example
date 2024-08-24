package com.example.tddexample.kiosk.unit.spring.domain.order;

import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderEntityTest {
    @DisplayName("주문 생성 시 상품 리스트에서 주문의총 금액을 계산한다,")
    @Test
    void calculatorTotalPrice() {
        //given
        List<Product> products = List.of(
                createProduct("001", 4000),
                createProduct("002", 3500)
        );
        //when
        Order order = new Order(products, LocalDateTime.now());

        //then
        assertThat(order.getTotalPrice()).isEqualTo(7500);
    }

    @DisplayName("주문 생성 시 주문 상태는 INIT 이다.")
    @Test
    void init() {
        //given
        List<Product> products = List.of(
                createProduct("001", 4000),
                createProduct("002", 3500)
        );

        LocalDateTime registeredDateTime = LocalDateTime.now();
        //when
        Order order = new Order(products, registeredDateTime);

        //then
        assertThat(order.getOrderStatus()).isEqualByComparingTo(OrderStatus.INIT);
    }

    @DisplayName("주문 생성 시 주문 등록 시간을 기록한다.")
    @Test
    void registeredDateTime() {
        //given
        LocalDateTime registeredDateTime = LocalDateTime.now();

        List<Product> products = List.of(
                createProduct("001", 4000),
                createProduct("002", 3500)
        );
        //when
        Order order = new Order(products, registeredDateTime);

        //then
        assertThat(order.getRegisteredDateTime()).isEqualTo(registeredDateTime);
    }

    private Product createProduct(String productNumber, int price) {
        return Product.create(
                productNumber,
                ProductType.HANDMADE,
                ProductSellingStatus.SELLING,
                "상품 이름",
                price
        );
    }
}