package com.example.tddexample.inflearn.part1.dynamic.sequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class IncrementSequenceTest {
    @DisplayName("")
    @Test
    void test() {
        int n = 8;
        int[] numbers = {5, 3, 7, 8, 6, 2, 9, 4};

        IncrementSequence sequence = new IncrementSequence(n, numbers);
        int result = sequence.lis();

        assertThat(result).isEqualTo(4);
    }
}