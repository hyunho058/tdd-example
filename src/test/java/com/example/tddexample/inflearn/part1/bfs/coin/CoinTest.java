package com.example.tddexample.inflearn.part1.bfs.coin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoinTest {
    @Test
    void test() {
        int n = 3;
        int[] m = new int[]{1, 2, 5};
        int sum = 15;
        Coin coin = new Coin(n, m, sum);
        int result = coin.bfs(0);

        assertThat(result).isEqualTo(3);
    }
}