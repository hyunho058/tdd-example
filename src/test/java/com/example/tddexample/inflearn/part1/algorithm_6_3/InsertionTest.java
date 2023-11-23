package com.example.tddexample.inflearn.part1.algorithm_6_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InsertionTest {
    @DisplayName("배열에 담긴 두 수를 2와 1을 비교하여 오름차순으로 정렬한다.")
    @Test
    void testCase1() {
        Insertion insertion = new Insertion();
        int[] result = insertion.sort(new int[]{2, 1});

        assertThat(result).containsExactly(1, 2);
    }

    @DisplayName("배열에 담긴 2, 3, 1를 비교하여 오름차순으로 정렬한다.")
    @Test
    void testCase2() {
        Insertion insertion = new Insertion();
        int[] result = insertion.sort(new int[]{2, 3, 1});

        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("배열에 담긴 수를 비교하여 오름차순으로 정렬한다.")
    @Test
    void testCase3() {
        Insertion insertion = new Insertion();
        int[] result = insertion.sort(new int[]{11, 7, 5, 6, 10, 9});

        assertThat(result).containsExactly(5,6,7,9,10,11);
    }
}
