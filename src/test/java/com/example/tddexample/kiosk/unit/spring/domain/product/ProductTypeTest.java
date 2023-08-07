package com.example.tddexample.kiosk.unit.spring.domain.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTypeTest {
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType() {
        //given
        ProductType type1 = ProductType.BOTTLE;
        ProductType type2 = ProductType.BAKERY;

        //when
        boolean result1 = ProductType.containsStockType(type1);
        boolean result2 = ProductType.containsStockType(type2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
    }
}
