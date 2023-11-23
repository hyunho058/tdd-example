package com.example.tddexample.inflearn.part1.dfs.hydrate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HydrateTest {
    @Test
    void test() {
        int c = 259;
        int n = 5;
        int[] weightArr = {81, 58, 42, 33, 61};

        Hydrate hydrate = new Hydrate(c, weightArr);
        hydrate.dfs(0, 0);

        assertThat(hydrate.result()).isEqualTo(242);
    }
}