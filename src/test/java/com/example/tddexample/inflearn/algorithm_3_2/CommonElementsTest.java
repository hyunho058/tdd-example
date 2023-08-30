package com.example.tddexample.inflearn.algorithm_3_2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CommonElementsTest {
    @Test
    void test() {
        CommonElements commonElements = new CommonElements();
        List<Integer> result = commonElements.getDuplicates(
            new int[]{1, 3, 9, 5, 2},
            new int[]{3, 2, 5, 7, 8}
        );

        assertThat(result).containsExactly(2, 3, 5);
    }
}