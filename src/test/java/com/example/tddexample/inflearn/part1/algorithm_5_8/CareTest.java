package com.example.tddexample.inflearn.part1.algorithm_5_8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CareTest {
    @DisplayName("")
    @Test
    void testCase1() {
        Care care = new Care();
        int result = care.orderNumber(new int[]{60, 50, 70, 80, 90}, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("")
    @Test
    void testCase2() {
        Care care = new Care();
        int result = care.orderNumber(new int[]{70, 60, 90, 60, 60, 60}, 3);

        assertThat(result).isEqualTo(4);
    }
}
