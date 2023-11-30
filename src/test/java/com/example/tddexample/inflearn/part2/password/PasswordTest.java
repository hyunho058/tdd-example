package com.example.tddexample.inflearn.part2.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordTest {
    @Test
    void testCase1() {
        int[] keypad = {2, 5, 3, 7, 1, 6, 4, 9, 8};
        String password = "7596218";

        Password p = new Password();
        int result = p.solution(keypad, password);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void testCase2() {
        int[] keypad = {1, 5, 7, 3, 2, 8, 9, 4, 6};
        String password = "63855526592";

        Password p = new Password();
        int result = p.solution(keypad, password);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void testCase3() {
        int[] keypad = {2, 9, 3, 7, 8, 6, 4, 5, 1};
        String password = "323254677";

        Password p = new Password();
        int result = p.solution(keypad, password);

        assertThat(result).isEqualTo(13);
    }
}