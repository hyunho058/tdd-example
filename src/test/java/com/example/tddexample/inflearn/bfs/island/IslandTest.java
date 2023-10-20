package com.example.tddexample.inflearn.bfs.island;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @DisplayName("섬이 존재하지 않을 경우 0을 반환한다.")
    @Test
    void test1() {
        int[][] map = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Island island = new Island(map);
        int amount = island.bfs();
        assertThat(amount).isEqualTo(0);
    }

    @DisplayName("1이 독립적으로 있을 경우 하나의 섬으로 판단한다.")
    @Test
    void test2() {
        int[][] map = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        Island island = new Island(map);
        int amount = island.bfs();
        assertThat(amount).isEqualTo(1);
    }

    @DisplayName("대각선으로 인접한 값들은 하나의 섬으로 판단한다.")
    @Test
    void test3() {
        int[][] map = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        Island island = new Island(map);
        int amount = island.bfs();
        assertThat(amount).isEqualTo(1);
    }

    @Test
    void test4() {
        int[][] map = {
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        };

        Island island = new Island(map);
        int amount = island.bfs();
        assertThat(amount).isEqualTo(5);
    }
}
