package com.example.tddexample.inflearn.peaksales;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SalesTest {
    /**
     * 1.N의 합을 구한다.
     * 2.N에서 5이고 K가 4일 경우 최대 합을 구한다.
     * 3.에서 두개의 합중 가장 큰 수를 확인
     */

    @DisplayName("N이 5이고 K가 5일 경우")
    @Test
    void case1(){
        Sales sales = new Sales();
        int result = sales.slidingWindow("1 2 3 4 5", 4);

        assertThat(result).isEqualTo(14);
    }

    @DisplayName("N이 5이고 K가 2일 경우")
    @Test
    void case2(){
        Sales sales = new Sales();
        int result = sales.slidingWindow("1 5 8 12 1", 2);

        assertThat(result).isEqualTo(20);
    }

    @DisplayName("N이 10이고 K가 3일 경우")
    @Test
    void case3(){
        Sales sales = new Sales();
        int result = sales.slidingWindow("12 15 11 20 25 10 20 19 13 1", 3);

        assertThat(result).isEqualTo(56);
    }
}