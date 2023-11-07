package com.example.tddexample.programmers.q43165;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TargetNumberTest {

    @DisplayName("{1,1} 배열 숫자에 - 또는 +를 조합해서 0을 만들수 있는 경우는 (-1,1), (1,-1) 2이다.")
    @Test
    void test0() {
        int target = 0;
        int[] numbers = {1, 1};

        TargetNumber targetNumber = new TargetNumber(target, numbers);
        int result = targetNumber.numberOfCases(0, 0);

        Assertions.assertThat(result).isEqualTo(2);
    }

    @DisplayName("{4,1,2,1} 배열 숫자에 - 또는 +를 조합해서 4를 만들수 있는 경우의 수는 2이다.")
    @Test
    void test1() {
        int target = 4;
        int[] numbers = {4, 1, 2, 1};

        TargetNumber targetNumber = new TargetNumber(target, numbers);
        int result = targetNumber.numberOfCases(0, 0);

        Assertions.assertThat(result).isEqualTo(2);
    }

    @DisplayName("{1,1,1,1,1} 배열 숫자에 - 또는 +를 조합해서 3를 만들수 있는 경우의 수는 5이다.")
    @Test
    void test2() {
        int target = 3;
        int[] numbers = {1, 1, 1, 1, 1};

        TargetNumber targetNumber = new TargetNumber(target, numbers);
        int result = targetNumber.numberOfCases(0, 0);

        Assertions.assertThat(result).isEqualTo(5);
    }
}
