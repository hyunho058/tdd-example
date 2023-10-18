package com.example.tddexample.inflearn.dfs.subset;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SubsetTest {
    @Test
    void test() {
        int n = 6;
        int[] numbers = {1, 3, 5, 6, 7, 10};
        int total = Arrays.stream(numbers).sum();

        Subset subset = new Subset(n, numbers, total);

        int level = 0;
        int sum = 0;
        subset.dfs(level, sum);

        assertThat(subset.result()).isEqualTo("YES");
    }

}