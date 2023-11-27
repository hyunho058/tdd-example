package com.example.tddexample.inflearn.part2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeatNumberTest {
    @DisplayName("")
    @Test
    void testCase1() {
        int c = 6;
        int r = 5;
        int k = 12;
        SeatNumber seatNumber = new SeatNumber();
        int[] result = seatNumber.solution(c, r, k);

        Assertions.assertThat(result).containsExactly(6, 3);
    }

    @DisplayName("")
    @Test
    void testCase2() {
        int c = 6;
        int r = 5;
        int k = 20;
        SeatNumber seatNumber = new SeatNumber();
        int[] result = seatNumber.solution(c, r, k);

        Assertions.assertThat(result).containsExactly(2, 3);
    }

    @DisplayName("")
    @Test
    void testCase3() {
        int c = 6;
        int r = 5;
        int k = 30;
        SeatNumber seatNumber = new SeatNumber();
        int[] result = seatNumber.solution(c, r, k);

        Assertions.assertThat(result).containsExactly(4, 3);
    }

    @DisplayName("")
    @Test
    void testCase4() {
        int c = 6;
        int r = 5;
        int k = 31;
        SeatNumber seatNumber = new SeatNumber();
        int[] result = seatNumber.solution(c, r, k);

        Assertions.assertThat(result).containsExactly(0, 0);
    }
}