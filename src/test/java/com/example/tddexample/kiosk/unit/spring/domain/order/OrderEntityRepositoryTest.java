package com.example.tddexample.kiosk.unit.spring.domain.order;

import com.example.tddexample.kiosk.unit.spring.IntegrationTestSupport;
import com.example.tddexample.kiosk.unit.spring.api.application.order.port.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class OrderEntityRepositoryTest extends IntegrationTestSupport {
    @Autowired
    private OrderRepository orderRepository;

    @DisplayName("주문 상태가 결제 완료와 선택한 날짜에 포함된 주문 목록을 가져온다.")
    @Test
    void findOrderBy() {
        //given
        LocalDateTime startDateTime  = LocalDateTime.of(2023, 1, 20, 9, 0, 0);
        LocalDateTime endDateTime  = LocalDateTime.of(2023, 2, 20, 0, 0, 0);
        LocalDateTime selectedIncludeData = LocalDateTime.of(2023, 1, 20, 10, 0, 0);
        Order order1 = Order.create(
                OrderStatus.PAYMENT_COMPLETED,
                10000,
                selectedIncludeData
        );
        Order order2 = Order.create(
                OrderStatus.CANCELED,
                12000,
                LocalDateTime.of(2023, 1, 21, 10, 0, 0)
        );
        Order order3 = Order.create(
                OrderStatus.PAYMENT_COMPLETED,
                15000,
                LocalDateTime.of(2023, 2, 20, 10, 0, 0)
        );

        orderRepository.saveAll(List.of(order1,order2, order3));

        //when
        List<Order> orders = orderRepository.findOrdersBy(
                startDateTime,
                endDateTime,
                OrderStatus.PAYMENT_COMPLETED
        );

        //then
        assertThat(orders).hasSize(1)
                .extracting("orderStatus", "totalPrice", "registeredDateTime")
                .containsExactlyInAnyOrder(
                        tuple(OrderStatus.PAYMENT_COMPLETED, 10000, selectedIncludeData)
                );
    }
}
