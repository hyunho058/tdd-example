package com.example.tddexample.inflearn.part1.algorithm_3_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoArraysTest {
    @DisplayName("test")
    @Test
    void test() {
        MergeTwoArrays mergeTwoArrays = new MergeTwoArrays();
        int[] results = mergeTwoArrays.merge(new int[]{1, 3, 5}, new int[]{2, 3, 6, 7, 9});

        assertThat(results).containsExactly(1, 2, 3, 3, 5, 6, 7, 9);
    }
}