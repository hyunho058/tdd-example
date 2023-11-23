package com.example.tddexample.inflearn.part1.dfs.maze;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeNavigationTest {
    @Test
    void test() {
        int[][] board = {

            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0}
        };
        MazeNavigation maze = new MazeNavigation(board);
        board[0][0] = 1;
        maze.dfs(0, 0);

        Assertions.assertThat(maze.getAnswer()).isEqualTo(8);
    }
}