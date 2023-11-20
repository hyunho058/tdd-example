package com.example.tddexample.inflearn.part1.dynamic.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ScoreTest {
    @DisplayName("")
    @Test
    void test() {
        int n = 5;
        int timeLimit = 20;
        int[][] problemArr = {
            {10, 5},
            {25, 12},
            {15, 8},
            {6, 3},
            {7, 4}
        };

        Score score = new Score(n ,timeLimit, problemArr);
        int result = score.maxScore();

        assertThat(result).isEqualTo(41);
    }
}