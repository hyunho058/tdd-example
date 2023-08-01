package com.example.tddexample.kiosk.unit.beverage;

public class Latte implements Beverage{
    @Override
    public String getName() {
        return "라떼";
    }

    @Override
    public int getPrice() {
        return 5_000;
    }
}
