package com.example.tddexample.inflearn.part1.algorithm_4_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxNumberTest {

    @DisplayName("정수 3개의 합중 첫 번째로 큰 수는 15이다.")
    @Test
    void findTheFirstLargestNumber() {
        MaxNumber maxNumber = new MaxNumber();
        int result = maxNumber.find(1, new Integer[]{6, 4, 5, 1, 2});

        assertThat(result).isEqualTo(15);
    }

    @DisplayName("정수 3개의 합중 첫 번째와 두 번째 큰수 합이 15로 동일 하여 두 번째로 큰 수는 14가 된다.")
    @Test
    void findTheSecondLargestNumber() {
        MaxNumber maxNumber = new MaxNumber();
        int result = maxNumber.find(2, new Integer[]{6, 4, 4, 1, 5});

        assertThat(result).isEqualTo(14);
    }

    @Test
    void test1() {
        MaxNumber maxNumber = new MaxNumber();
        int result = maxNumber.find(
                20,
                new Integer[]{
                        38, 46, 54, 33, 34,
                        23, 48, 50, 23, 26,
                        46, 47, 25, 48, 35,
                        48, 32, 30, 50, 28,
                        39, 34, 24, 28, 26,
                        53, 18, 24, 52, 41,
                        41, 33, 23, 52, 27,
                        22, 45, 30, 52, 19,
                        40, 48, 45, 23, 21,
                        45, 19, 20, 38, 21,
                        19, 21, 31, 40, 53,
                        27, 49, 48, 30, 32
                }
        );

        assertThat(result).isEqualTo(141);
    }

    @DisplayName("정수 내림 차순 정렬")
    @Test
    void sortInDescendingOrder() {
        Integer[] ints = {1, 4, 3, 5, 2};
        Arrays.sort(ints);
        Arrays.sort(ints, (i1, i2) -> i2 - i1);

        assertThat(ints).containsExactly(5, 4, 3, 2, 1);
    }
}
