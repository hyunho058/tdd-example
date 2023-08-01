package com.example.tddexample.kiosk.unit;

import com.example.tddexample.kiosk.unit.beverage.Beverage;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {
    private final LocalDateTime orderTime;
    private final List<Beverage> beverages;

    public Order(LocalDateTime orderTime, List<Beverage> beverages) {
        this.orderTime = orderTime;
        this.beverages = beverages;
    }
}
