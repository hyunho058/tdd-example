package com.example.tddexample.inflearn.part2.sort.place;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlaceTest {

    @Test
    void testCase1() {
        int[][] board = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        Place place = new Place();
        int result = place.solution(board);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void testCase2() {
        int[][] board = new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };

        Place place = new Place();
        int result = place.solution(board);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void testCase3() {
        int[][] board = new int[][]{
                {1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1}
        };

        Place place = new Place();
        int result = place.solution(board);

        assertThat(result).isEqualTo(37);
    }
}
