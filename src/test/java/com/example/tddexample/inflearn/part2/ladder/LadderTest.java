package com.example.tddexample.inflearn.part2.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("")
    @Test
    void testCase1() {
        int n = 5;
        int[][] ladderArr = {
            {1, 3},
            {2, 4},
            {1, 4}
        };

        Ladder ladder = new Ladder();
        char[] result = ladder.solution(n, ladderArr);

        assertThat(result).containsExactly('D', 'B', 'A', 'C', 'E');
    }

    @DisplayName("")
    @Test
    void testCase2() {
        int n = 7;
        int[][] ladderArr = {{1, 3, 5}, {1, 3, 6}, {2, 4}};

        Ladder ladder = new Ladder();
        char[] result = ladder.solution(n, ladderArr);

        assertThat(result).containsExactly('A','C','B','F','D','G','E');
    }
}