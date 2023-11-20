package com.example.tddexample.inflearn.part1.algorithm_5_3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ClawCraneTest {
    /**
     * 5
     * 0 0 0 0 0
     * 0 0 1 0 3
     * 0 2 5 0 1
     * 4 2 4 4 2
     * 3 5 1 3 1
     * 8
     * 크레인 움직이는 순서 => 1 5 3 5 1 2 1 4
     * <p>
     * 인형이 뽑혀 쌓인 순서 => 4 3 1 1 3 2 4
     * 1 인형이 겹처 사라지고 count는 2가 된다 이후 3이 두개 겹처 사라지고 count가 4가 된다.
     */
    @Test
    void testCase1() {
        int[][] board = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };

        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        ClawCrane clawCrane = new ClawCrane();
        int result = clawCrane.dollsCount(board, moves);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void testCase2() {
        int[][] board = new int[][]{
            {2, 3},
            {1, 3}
        };

        int[] moves = new int[]{1, 1, 2, 2};

        ClawCrane clawCrane = new ClawCrane();
        int result = clawCrane.dollsCount(board, moves);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void testCase3() {
        int[][] board = new int[][]{
            {2, 3},
            {1, 3}
        };

        int[] moves = new int[]{1, 2, 1, 2};

        ClawCrane clawCrane = new ClawCrane();
        int result = clawCrane.dollsCount(board, moves);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void testCase4() {
        int[][] board = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        int[] moves = new int[]{1, 2, 1, 2};

        ClawCrane clawCrane = new ClawCrane();
        int result = clawCrane.dollsCount(board, moves);

        assertThat(result).isEqualTo(0);
    }
}
