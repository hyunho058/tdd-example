package com.example.tddexample.kiosk.unit.spring.domain.stock;

import com.example.tddexample.kiosk.unit.spring.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "stock")
@Entity
public class StockEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    private int quantity;

    protected StockEntity() {
    }

    public StockEntity(String productNumber, int quantity) {
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

