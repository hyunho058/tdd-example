package com.example.tddexample.inflearn.algorithm_3_4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PartialSequenceTest {
    @Test
    void test() {
        PartialSequence partialSequence = new PartialSequence();

        int result = partialSequence.calculate(8,6,new int[]{1,2,1,3,1,1,1,2});

        assertThat(result).isEqualTo(3);
    }
}
