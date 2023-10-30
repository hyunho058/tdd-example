package com.example.tddexample.inflearn.greedy.wonderland;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WonderlandTest {
    @DisplayName("")
    @Test
    void test() {
        int v = 9;
        int e = 12;
        int[][] loads = {
            {1, 2, 12},
            {1, 9, 25},
            {2, 3, 10},
            {2, 8, 17},
            {2, 9, 8},
            {3, 4, 18},
            {3, 7, 55},
            {4, 5, 44},
            {5, 6, 60},
            {5, 7, 38},
            {7, 8, 35},
            {8, 9, 15},
        };

        Wonderland wonderland = new Wonderland(v, e, loads);
        int cost = wonderland.getMinCost();

        assertThat(cost).isEqualTo(196);
    }
}