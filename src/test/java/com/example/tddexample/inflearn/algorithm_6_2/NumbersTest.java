package com.example.tddexample.inflearn.algorithm_6_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("숫자 1과 2를 입력 받으면 1, 2 순으로 정렬된다.")
    @Test
    void testCase1() {
        Numbers numbers = new Numbers();
        int[] result = numbers.sort(new int[]{2, 1});

        assertThat(result).containsExactly(1, 2);
    }

    @DisplayName("입력받은 숫자는 오름차순 으로 정렬된다.")
    @Test
    void testCase2() {
        Numbers numbers = new Numbers();
        int[] result = numbers.sort(new int[]{13, 5, 11, 7, 23, 15});

        assertThat(result).containsExactly(5, 7, 11, 13, 15, 23);
    }
}
