package com.example.tddexample.inflearn.part2.greedy.titanic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TitanicTest {

    @Test
    void testCase1() {
        // 100 90 70 60 50
        int[] nums = {90, 50, 70, 100, 60};
        int m = 140;

        Titanic titanic = new Titanic();
        int result = titanic.boatCount(nums, m);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void testCase2() {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        //90 80 70 60 50 40 30 20 10
        // 90 10   80 20  70 30   60 40
        int m = 150;

        Titanic titanic = new Titanic();
        int result = titanic.boatCount(nums, m);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void testCase3() {
        int[] nums = {
            68, 72, 30, 105, 55,
            115, 36, 67, 119, 111,
            95, 24, 25, 80, 55,
            85, 75, 83, 21, 81
        };
        int m = 120;

        Titanic titanic = new Titanic();
        int result = titanic.boatCount(nums, m);

        assertThat(result).isEqualTo(14);
    }
}
