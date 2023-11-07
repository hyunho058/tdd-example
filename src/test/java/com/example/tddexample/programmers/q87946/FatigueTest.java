package com.example.tddexample.programmers.q87946;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
class FatigueTest {
    @DisplayName("")
    @Test
    void test() {
        int k = 80;
        int[][] dungeons = {
            {80, 20},
            {50, 40},
            {30, 10}
        };

        Fatigue fatigue = new Fatigue(k, dungeons);
        int count = fatigue.maxExploration(k);

        assertThat(count).isEqualTo(3);
    }
}