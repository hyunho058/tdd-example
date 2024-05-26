package com.example.tddexample.kiosk.unit.spring.api.application.order;

import java.time.LocalDate;

public interface OrderStatisticsService {
    boolean sendOrderStatisticsMail(LocalDate orderDate, String mail);
}
