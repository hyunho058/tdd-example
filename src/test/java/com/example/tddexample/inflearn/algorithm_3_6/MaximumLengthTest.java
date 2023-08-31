package com.example.tddexample.inflearn.algorithm_3_6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumLengthTest {
    //리스트 순회 하면서 point1, point2 범위를 늘려간다.
    //1이면 증가 하고, 0일 경우 n밧을 감소 하면서 범위를 늘려간다.
    //n이 0이 되고  다음 이진수가 0 이면 한 범위 종료
    @Test
    void case1() {
        MaximumLength maximumLength = new MaximumLength();

        int result = maximumLength.transformation(
                2,
                new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}
        );

        assertThat(result).isEqualTo(8);
    }

    @Test
    void case2() {
        MaximumLength maximumLength = new MaximumLength();

        int result = maximumLength.transformation(
                1,
                new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}
        );

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case3() {
        MaximumLength maximumLength = new MaximumLength();

        int result = maximumLength.transformation(
                5,
                new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}
        );

        assertThat(result).isEqualTo(14);
    }

    @Test
    void case4() {
        MaximumLength maximumLength = new MaximumLength();

        int result = maximumLength.transformation(
                1,
                new int[]{0, 0, 0, 0, 0, 1, 0, 0}
        );

        assertThat(result).isEqualTo(2);
    }
}
