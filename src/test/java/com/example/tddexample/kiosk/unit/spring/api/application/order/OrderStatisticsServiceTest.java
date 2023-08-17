package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistory;
import com.example.tddexample.kiosk.unit.spring.domain.history.mail.MailSendHistoryRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;
import com.example.tddexample.kiosk.unit.spring.domain.product.Product;
import com.example.tddexample.kiosk.unit.spring.domain.product.ProductRepository;
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
class OrderStatisticsServiceTest extends IntegrationTestSupport {

    @Autowired
    private OrderStatisticsService orderStatisticsService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MailSendHistoryRepository mailSendHistoryRepository;

    @DisplayName("결제완료 주문들을 조회화여 매출 통계 메일을 전송한다.")
    @Test
    void sendOrderStatisticsMail() {
        //given
        Product product1 = createProduct("001", ProductType.BOTTLE, 4000);
        Product product2 = createProduct("002", ProductType.BAKERY, 4500);
        Product product3 = createProduct("003", ProductType.HANDMADE, 5000);
        productRepository.saveAll(List.of(product1, product2, product3));

        LocalDateTime registeredDateTime = LocalDateTime.of(2023, 1, 20, 10, 0, 0);
        Order newOrder1 = new Order(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                LocalDateTime.of(2023, 1, 19, 23, 59, 59));
        Order newOrder2 = new Order(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                registeredDateTime);
        Order newOrder3 = new Order(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                LocalDateTime.of(2023, 1, 20, 23, 59, 59));
        Order newOrder4 = new Order(
                OrderStatus.PAYMENT_COMPLETED,
                List.of(product1, product2, product3),
                LocalDateTime.of(2023, 1, 21, 0, 0, 0));
        orderRepository.saveAll(List.of(newOrder1, newOrder2, newOrder3, newOrder4));

        //stubbing
        when(mailSendClient.send(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(true);

        //when
        LocalDate findLocalDate = LocalDate.of(2023, 1, 20);
        boolean result = orderStatisticsService.sendOrderStatisticsMail(findLocalDate, "test@test.com");


        //then
        assertThat(result).isTrue();

        List<MailSendHistory> mailSendHistories = mailSendHistoryRepository.findAll();
        assertThat(mailSendHistories).hasSize(1)
                .extracting("content")
                .contains("내용 총 매출 합계 = 27000");
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
