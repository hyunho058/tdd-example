package com.example.tddexample.inflearn.part1.dfs.combination;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationTest {

    @DisplayName("n 과 r 이 같으면 1을 반환")
    @Test
    void test1() {
        int n = 5;
        int r = 5;
        Combination combination = new Combination(new int[n + 1][r + 1]);
        int result = combination.dfs(n, r);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("r이 0 이면 1을 반환")
    @Test
    void test2() {
        int n = 5;
        int r = 0;
        Combination combination = new Combination(new int[n + 1][r + 1]);
        int result = combination.dfs(n, r);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("n이 5, r이 3이면 조합의 경우의 수는 10이다.")
    @Test
    void test3() {
        int n = 5;
        int r = 3;
        Combination combination = new Combination(new int[n + 1][r + 1]);
        int result = combination.dfs(n, r);

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("n이 33, r이 19이면 조합의 경우의 수는 818809200이다.")
    @Test
    void test4() {
        int n = 33;
        int r = 19;
        Combination combination = new Combination(new int[n + 1][r + 1]);
        int result = combination.dfs(n, r);

        assertThat(result).isEqualTo(818809200);
    }
}
