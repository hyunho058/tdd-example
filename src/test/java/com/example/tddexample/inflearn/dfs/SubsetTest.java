package com.example.tddexample.inflearn.dfs;

import org.junit.jupiter.api.Test;

public class SubsetTest {
    @Test
    void test() {
        int n = 3;
        Subset subset = new Subset(n);
        subset.dfs(1);
    }
}
