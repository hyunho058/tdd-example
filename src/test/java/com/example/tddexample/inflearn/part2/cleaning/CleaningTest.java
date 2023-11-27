package com.example.tddexample.inflearn.part2.cleaning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CleaningTest {
    @Test
    void testCase1() {
        Cleaning cleaning = new Cleaning();
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}
        };
        int k = 10;
        int[] endPosition = cleaning.solution(board, k);

        assertThat(endPosition).containsExactly(2, 2);
    }

    @Test
    void testCase2() {
        Cleaning cleaning = new Cleaning();
        int[][] board = {
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };
        int k = 20;
        int[] endPosition = cleaning.solution(board, k);

        assertThat(endPosition).containsExactly(4, 5);
    }

    @DisplayName("")
    @Test
    void testCase3() {

        Cleaning cleaning = new Cleaning();
        int[][] board = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };
        int k = 25;
        int[] endPosition = cleaning.solution(board, k);

        assertThat(endPosition).containsExactly(0, 1);

    }
}