package com.example.tddexample.inflearn.greedy.wedding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WeddingTest {
    @DisplayName("피로연에 동시에 가장 많이 참석하는 인원 수")
    @Test
    void test() {
        int n = 5;
        int[][] scheduleArr = {
            {14, 18},
            {12, 15},
            {15, 20},
            {20, 30},
            {5, 14}
        };

        Wedding wedding = new Wedding(n, scheduleArr);
        int result = wedding.greedy();

        assertThat(result).isEqualTo(2);
    }
}