package com.example.tddexample.inflearn.part2.greedy.sprinkler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SprinklerTest {
    @Test
    void testCase1() {
        int[] nums = new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1};
        int n = 8;

        Sprinkler sprinkler = new Sprinkler();
        int result = sprinkler.solution(n, nums);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void testCase2() {
        int[] nums = new int[]{1, 2, 2, 0, 0};
        int n = 5;

        Sprinkler sprinkler = new Sprinkler();
        int result = sprinkler.solution(n, nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void testCase3() {
        int[] nums = new int[]{2, 0, 0, 0, 0, 2};
        int n = 5;

        Sprinkler sprinkler = new Sprinkler();
        int result = sprinkler.solution(n, nums);

        assertThat(result).isEqualTo(-1);
    }
}
