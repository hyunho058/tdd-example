package com.example.tddexample.inflearn.part1.dynamic.tower;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TowerTest {

    @DisplayName("넓이가 4, 무게가 3인 블록이 넓이와 무게가 5인 블록 보다 넓이와 무게가 작기 때문에 쌓을수 있어 높이는 3이 된다.")
    @Test
    void ableStacked() {
        int n = 2;
        int[][] blockArr = {
                {5, 2, 5},
                {4, 1, 3}
        };

        Tower tower = new Tower(n, blockArr);
        int height = tower.maximumHeight();

        assertThat(height).isEqualTo(3);
    }

    @DisplayName("최대 높이로 쌓을수 있는 높이는 10이다.")
    @Test
    void test() {
        int n = 5;
        int[][] blockArr = {
                {25, 3, 4},
                {4, 4, 6},
                {9, 2, 3},
                {16, 2, 5},
                {1, 5, 2}
        };

        Tower tower = new Tower(n, blockArr);
        int height = tower.maximumHeight();

        assertThat(height).isEqualTo(10);
    }
}
