package com.example.tddexample.inflearn.algorithm_6_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentNumberTest {
    @DisplayName("배열에 담긴 두 수가 중복이기 때문에 결과 값은 D(duplicate)이다.")
    @Test
    void duplicateNumber() {
        int[] numbers = {1, 1};

        StudentNumber number = new StudentNumber();
        String result = number.checkDuplicates(numbers);

        assertThat(result).isEqualTo("D");
    }

    @DisplayName("배열에 담긴 두 수가 중복이 아니기 때문에 결과 값은 U(unique)이다.")
    @Test
    void noDuplicateNumber() {
        int[] numbers = {1, 2};

        StudentNumber number = new StudentNumber();
        String result = number.checkDuplicates(numbers);

        assertThat(result).isEqualTo("U");
    }

    @DisplayName("중복이 없는 경우")
    @Test
    void testCase1() {
        int[] numbers = {15, 12, 21, 14, 100, 24};

        StudentNumber number = new StudentNumber();
        String result = number.checkDuplicates(numbers);

        assertThat(result).isEqualTo("U");
    }
}
