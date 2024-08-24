package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import com.example.tddexample.kiosk.unit.spring.infrastructure.MailSendHistoryEntity;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryJpaRepository;
import com.example.tddexample.kiosk.unit.spring.infrastructure.product.OrderEntity;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;
import com.example.tddexample.kiosk.unit.spring.infrastructure.order.ProductEntity;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductJpaRepository;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductSellingStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@ActiveProfiles("test")
//@SpringBootTest
@Transactional
class OrderEntityStatisticsServiceTest extends IntegrationTestSupport {

    @Autowired
    private OrderStatisticsService orderStatisticsService;
    @Autowired
    private OrderJpaRepository orderJpaRepository;
    @Autowired
    private ProductJpaRepository productJPARepository;
    @Autowired
    private MailSendHistoryJpaRepository mailSendHistoryJpaRepository;

    @DisplayName("결제완료 주문들을 조회화여 매출 통계 메일을 전송한다.")
    @Test
    void sendOrderStatisticsMail() {
        //given
        ProductEntity product1 = createProduct("001", ProductType.BOTTLE, 4000);
        ProductEntity product2 = createProduct("002", ProductType.BAKERY, 4500);
        ProductEntity product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productJPARepository.saveAll(List.of(product1, product2, product3));

        LocalDateTime registeredDateTime = LocalDateTime.of(2023, 1, 20, 10, 0, 0);
        OrderEntity newOrder1 = new OrderEntity(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                LocalDateTime.of(2023, 1, 19, 23, 59, 59));
        OrderEntity newOrder2 = new OrderEntity(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                registeredDateTime);
        OrderEntity newOrder3 = new OrderEntity(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                LocalDateTime.of(2023, 1, 20, 23, 59, 59));
        OrderEntity newOrder4 = new OrderEntity(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                LocalDateTime.of(2023, 1, 21, 0, 0, 0));
        orderJpaRepository.saveAll(List.of(newOrder1, newOrder2, newOrder3, newOrder4));

        //stubbing
        when(mailSendClient.send(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(true);

        //when
        LocalDate findLocalDate = LocalDate.of(2023, 1, 20);
        boolean result = orderStatisticsService.sendOrderStatisticsMail(findLocalDate, "test@test.com");


        //then
        assertThat(result).isTrue();

        List<MailSendHistoryEntity> mailSendHistories = mailSendHistoryJpaRepository.findAll();
        assertThat(mailSendHistories).hasSize(1)
                .extracting("content")
                .contains("내용 총 매출 합계 = 27000");
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
