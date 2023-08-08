package com.example.tddexample.kiosk.unit.spring.api.application.order;

import com.example.tddexample.kiosk.unit.spring.domain.order.Order;
import com.example.tddexample.kiosk.unit.spring.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderStatisticsService {
    private final OrderRepository orderRepository;

    public void sendOrderStatisticsMail(LocalDateTime orderDate, String mail) {
        //해당 일자에 결제완료된 주문들을 가져와서
//        List<Order> orders = orderRepository.findOrderBy();
        //총 매출 합계를 계산

        //메일 전송

    }
}
