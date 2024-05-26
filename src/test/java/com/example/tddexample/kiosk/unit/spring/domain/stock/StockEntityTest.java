package com.example.tddexample.kiosk.unit.spring.domain.stock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StockEntityTest {
    @DisplayName("재고가 2개이고 주문 수량이 2이면 재고는 0이다.")
    @Test
    void reduceStockQuantity() {
        //given
        StockEntity stock = new StockEntity("001", 2);
        int orderQuantity = 2;

        //when
        stock.reduceQuantity(orderQuantity);

        //then
        assertThat(stock.getQuantity()).isEqualTo(0);
    }

    @DisplayName("재고가 0개이고 주문 수량이 1이면 exception 발생")
    @Test
    void reduceStockWithZeroQuantity() {
        //given
        StockEntity stock = new StockEntity("001", 0);
        int orderQuantity = 1;

        //when
        // then
        assertThatThrownBy(() -> stock.reduceQuantity(orderQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재고가 0입니다.");
    }
    @DisplayName("재고가 1개이고 주문 수량이 2이면 주문한 수 만큼 재고가 없는 exception 발생")
    @Test
    void reduceStockWithInsufficientQuantity() {
        //given
        StockEntity stock = new StockEntity("001", 1);
        int orderQuantity = 2;

        //when
        // then
        assertThatThrownBy(() -> stock.reduceQuantity(orderQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문한 수량보다 재고가 적습니다.");
    }
}
