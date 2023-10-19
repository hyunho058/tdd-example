package com.example.tddexample.inflearn.dfs.tomato;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TomatoTest {
    @DisplayName("토마토가 모두 익을 때까지의 최소 날짜를 출력")
    @Test
    void test() {
        int[][] box = {
            {0, 0, -1, 0, 0, 0},
            {0, 0, 1, 0, -1, 0},
            {0, 0, -1, 0, 0, 0},
            {0, 0, 0, 0, -1, 1}
        };
        Tomato main = new Tomato(box);
        int minimumNumberOfDays = main.bfs();

        assertThat(minimumNumberOfDays).isEqualTo(4);
    }
}