package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.request.OrderCreateRequest;
import com.example.tddexample.kiosk.unit.spring.api.presentation.order.response.OrderResponse;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.orderproduct.OrderProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.infrastructure.order.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import com.example.tddexample.kiosk.unit.spring.domain.stock.StockEntity;
import com.example.tddexample.kiosk.unit.spring.domain.stock.StockRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

@Transactional
class OrderEntityServiceImplTest extends IntegrationTestSupport {
    @Autowired
    private OrderServiceImpl orderServiceImpl;
    @Autowired
    private ProductJpaRepository productJPARepository;
    @Autowired
    private OrderJpaRepository orderJpaRepository;
    @Autowired
    private OrderProductJpaRepository orderProductJpaRepository;
    @Autowired
    private StockRepository stockRepository;

//    @AfterEach
//    void tearDown() {
//        orderProductRepository.deleteAllInBatch();
//        productRepository.deleteAllInBatch();
//        orderRepository.deleteAllInBatch();
//    }

    @DisplayName("주문번호 리스트를 받아 주문을 생성한다.")
    @Test
    void createOrder() {
        //given
        ProductEntity product1 = createProduct("001", ProductType.HANDMADE, 4000);
        ProductEntity product2 = createProduct("002", ProductType.HANDMADE, 4500);
        ProductEntity product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productJPARepository.saveAll(List.of(product1, product2, product3));

        OrderCreateRequest request = new OrderCreateRequest(List.of("001", "002"));
        LocalDateTime nowDateTine = LocalDateTime.now();
        //when
        OrderResponse orderResponse = orderServiceImpl.createOrder(request.toServiceRequest(), nowDateTine);

        //then
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
        //given
        ProductEntity product1 = createProduct("001", ProductType.HANDMADE, 4000);
        ProductEntity product2 = createProduct("002", ProductType.HANDMADE, 4500);
        ProductEntity product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productJPARepository.saveAll(List.of(product1, product2, product3));

        OrderCreateRequest request = new OrderCreateRequest(List.of("001", "001"));
        LocalDateTime nowDateTine = LocalDateTime.now();
        //when
        OrderResponse orderResponse = orderServiceImpl.createOrder(request.toServiceRequest(), nowDateTine);

        //then
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

    @DisplayName("재고와 관련된 상품이 포함되어 있는 주문번호 리스트를 받아 주문을 생성한다.")
    @Test
    void createOrderWithStock() {
        //given
        LocalDateTime nowDateTine = LocalDateTime.now();

        ProductEntity product1 = createProduct("001", ProductType.BOTTLE, 4000);
        ProductEntity product2 = createProduct("002", ProductType.BAKERY, 4500);
        ProductEntity product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productJPARepository.saveAll(List.of(product1, product2, product3));

        StockEntity stock1 = new StockEntity("001", 2);
        StockEntity stock2 = new StockEntity("002", 2);
        stockRepository.saveAll(List.of(stock1, stock2));

        OrderCreateRequest request = new OrderCreateRequest(List.of("001", "001", "002", "003"));

        //when
        OrderResponse orderResponse = orderServiceImpl.createOrder(request.toServiceRequest(), nowDateTine);

        //then
        assertThat(orderResponse)
                .extracting("registeredDateTime", "totalPrice")
                .contains(nowDateTine, 17500);
        assertThat(orderResponse.getProducts()).hasSize(4)
                .extracting("productNumber", "price")
                .containsExactlyInAnyOrder(
                        tuple("001", 4000),
                        tuple("001", 4000),
                        tuple("002", 4500),
                        tuple("003", 5000)
                );

        List<StockEntity> stocks = stockRepository.findAll();
        assertThat(stocks).hasSize(2)
                .extracting("productNumber", "quantity")
                .containsExactlyInAnyOrder(
                        tuple("001", 0),
                        tuple("002", 1)
                );
    }

    @DisplayName("재고가 없는 상품으로 주문을 생성하는 경우 예외가 발생한다.")
    @Test
    void createOrderWithNoStock() {
        //given
        LocalDateTime nowDateTine = LocalDateTime.now();

        ProductEntity product1 = createProduct("001", ProductType.BOTTLE, 4000);
        ProductEntity product2 = createProduct("002", ProductType.BAKERY, 4500);
        ProductEntity product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productJPARepository.saveAll(List.of(product1, product2, product3));

        StockEntity stock1 = new StockEntity("001", 1);
        StockEntity stock2 = new StockEntity("002", 1);
        stockRepository.saveAll(List.of(stock1, stock2));

        OrderCreateRequest request = new OrderCreateRequest(List.of("001", "001", "002", "003"));

        //when //then
        assertThatThrownBy(() -> orderServiceImpl.createOrder(request.toServiceRequest(), nowDateTine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문한 수량보다 재고가 적습니다.");
    }

    private ProductEntity createProduct(String productNumber, ProductType type, int price) {
        return new ProductEntity(
            productNumber,
            type,
            ProductSellingStatus.SELLING,
            "상품 이름",
            price
        );
    }
}
