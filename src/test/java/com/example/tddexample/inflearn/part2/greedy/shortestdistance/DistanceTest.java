package com.example.tddexample.inflearn.part2.greedy.shortestdistance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

    @Test
    void testCase1() {
        int[] plantTime = new int[]{1, 3, 2};
        int[] growTime = new int[]{2, 3, 2};

        Distance distance = new Distance();
        int result = distance.calculateMinimumHarvestTime(plantTime, growTime);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void testCase2() {
        int[] plantTime = new int[]{2, 1, 4, 3};
        int[] growTime = new int[]{2, 5, 3, 1};

        Distance distance = new Distance();
        int result = distance.calculateMinimumHarvestTime(plantTime, growTime);

        assertThat(result).isEqualTo(11);
    }

    @Test
    void testCase3() {
        int[] plantTime = new int[]{1, 1, 1};
        int[] growTime = new int[]{7, 3, 2};

        Distance distance = new Distance();
        int result = distance.calculateMinimumHarvestTime(plantTime, growTime);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void testCase4() {
        int[] plantTime = new int[]{5, 7, 10, 15, 7, 3, 5};
        int[] growTime = new int[]{6, 7, 2, 10, 15, 6, 7};

        Distance distance = new Distance();
        int result = distance.calculateMinimumHarvestTime(plantTime, growTime);

        assertThat(result).isEqualTo(54);
    }
}
