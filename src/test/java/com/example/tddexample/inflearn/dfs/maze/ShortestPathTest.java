package com.example.tddexample.inflearn.dfs.maze;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortestPathTest {
    @Test
    void test() {
        int[][] paths = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 0}
        };

        ShortestPath shortestPath = new ShortestPath(paths);
        int result = shortestPath.bfs(0, 0);

        Assertions.assertThat(result).isEqualTo(12);
    }
}