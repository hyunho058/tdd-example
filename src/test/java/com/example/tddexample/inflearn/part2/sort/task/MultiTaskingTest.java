package com.example.tddexample.inflearn.part2.sort.task;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MultiTaskingTest {
    @DisplayName("")
    @Test
    void testCase1() {
        int[] tasks = new int[]{1, 2, 3};
        int second = 5;

        MultiTasking multiTasking = new MultiTasking();
        int result = multiTasking.solution(tasks, second);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("")
    @Test
    void test() {
        int totalTask = 6;
        int k = 5;

        System.out.println(k % totalTask);
    }

    @Test
    void testCase2() {
        int[] tasks = new int[]{8, 5, 2, 9, 10, 7};
        int second = 30;

        MultiTasking multiTasking = new MultiTasking();
        int result = multiTasking.solution(tasks, second);

        assertThat(result).isEqualTo(6);
    }

    /**
     * 8 5 2 9 10 7
     * 7 4 1 8 9  6
     * 6 3 0 7 8  5
     * 5 2 0 6 7  4
     * 4 1 0 5 6  3
     * 3 0 0 4 5/ 2
     */

    @Test
    void testCase3() {
        int[] tasks = new int[]{8, 9, 12, 23, 45, 16, 25, 50};
        int second = 100;

        MultiTasking multiTasking = new MultiTasking();
        int result = multiTasking.solution(tasks, second);

        assertThat(result).isEqualTo(5);
    }
}
