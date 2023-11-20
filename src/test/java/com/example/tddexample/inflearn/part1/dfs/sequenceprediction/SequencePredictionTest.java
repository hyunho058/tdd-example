package com.example.tddexample.inflearn.part1.dfs.sequenceprediction;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SequencePredictionTest {
    @DisplayName("")
    @Test
    void test() {
        int n = 4;
        int f = 16;

        SequencePrediction.Combination combination = new SequencePrediction.Combination(n);
        int[] combinations = combination.calcCombinations();

        SequencePrediction sequencePrediction = new SequencePrediction(n, f, combinations);
        sequencePrediction.dfs(0, 0);

        int[] result = new int[]{1, 2, 3};
        Assertions.assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void test1() {
        SequencePrediction.Combination combination = new SequencePrediction.Combination(3);
        int[] results = combination.calcCombinations();

        Assertions.assertThat(results).containsExactly(1, 2, 1);
    }
}
