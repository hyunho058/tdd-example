package com.example.tddexample.inflearn.part2.sort.sequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindSequenceTest {

    @Test
    void testCase1() {
        int[] nums = {1, 10, 2, 3, 5, 6};

        FindSequence findSequence = new FindSequence();
        int[] result = findSequence.solution(nums);

        assertThat(result).containsExactly(1, 3, 5);
    }

    @Test
    void testCase2() {
        int[] nums = {14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14};

        FindSequence findSequence = new FindSequence();
        int[] result = findSequence.solution(nums);

        assertThat(result).containsExactly(2, 3, 5, 5, 7, 7);
    }

    @Test
    void testCase3() {
        int[] nums = {1, 1, 6, 2, 2, 7, 3, 14};

        FindSequence findSequence = new FindSequence();
        int[] result = findSequence.solution(nums);

        assertThat(result).containsExactly(1, 1, 3, 7);
    }
}
