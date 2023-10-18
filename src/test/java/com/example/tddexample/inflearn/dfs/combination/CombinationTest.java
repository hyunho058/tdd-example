package com.example.tddexample.inflearn.dfs.combination;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CombinationTest {
    @Test
    void test() {
        int n = 5;
        int r = 3;
        Combination combination = new Combination(new int[n+1][r+1]);
        int result = combination.dfs(n, r);

        Assertions.assertThat(result).isEqualTo(10);
    }
}