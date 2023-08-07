package com.example.tddexample.kiosk.unit.spring.domain.stock;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Stock extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    private int quantity;

    protected Stock() {
    }

    public Stock(String productNumber, int quantity) {
        this.productNumber = productNumber;
        this.quantity = quantity;
    }

    public void reduceQuantity(int orderQuantity) {
        if (this.quantity <= 0) {
            throw new IllegalArgumentException("재고가 0입니다.");
        }

        if (this.quantity < orderQuantity) {
            throw new IllegalArgumentException("주문한 수량보다 재고가 적습니다.");
        }

        this.quantity -= orderQuantity;
    }
}

