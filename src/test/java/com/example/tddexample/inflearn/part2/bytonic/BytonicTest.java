package com.example.tddexample.inflearn.part2.bytonic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BytonicTest {

    @Test
    void testCase1() {
        int[] nums = {1, 3, 2, 5, 7, 4, 2, 5, 1};
        Bytonic bytonic = new Bytonic();
        int result = bytonic.solution(nums);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void testCase2() {
        int[] nums = {1, 1, 2, 3, 5, 7, 4, 3, 1, 2};
        Bytonic bytonic = new Bytonic();
        int result = bytonic.solution(nums);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void testCase3() {
        int[] nums = {3, 2, 1, 3, 2, 4, 6, 7, 3, 1};
        Bytonic bytonic = new Bytonic();
        int result = bytonic.solution(nums);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void testCase4() {
        int[] nums = {1, 3, 1, 2, 1, 5, 3, 2, 1, 1};
        Bytonic bytonic = new Bytonic();
        int result = bytonic.solution(nums);

        assertThat(result).isEqualTo(5);
    }
}