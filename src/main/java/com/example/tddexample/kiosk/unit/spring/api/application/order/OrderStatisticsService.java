package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderRepository;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderStatisticsService {
    private final OrderRepository orderRepository;
    private final MailService mailService;

    public boolean sendOrderStatisticsMail(LocalDate orderDate, String mail) {
        //해당 일자에 결제완료된 주문들을 가져와서
        List<Order> orders = orderRepository.findOrdersBy(
                orderDate.atStartOfDay(),
                orderDate.plusDays(1).atStartOfDay(),
                OrderStatus.PAYMENT_COMPLETED
        );

        //총 매출 합계를 계산
        int ordersTotalPrice = orders.stream()
                .mapToInt(Order::getTotalPrice)
                .sum();

        //메일 전송
        boolean result = mailService.send(
                "no-replay@cafekiosk.com",
                mail,
                String.format("[총 매출] %s", orderDate),
                String.format("내용 총 매출 합계 = %s", ordersTotalPrice));

        if (!result) {
            throw new IllegalArgumentException("매출 총계 메일 전송애 실패했습니다.");
        }

        return true;
    }
}
