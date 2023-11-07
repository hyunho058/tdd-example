package com.example.tddexample.programmers.q138476;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TangerineTest {
    @DisplayName("")
    @Test
    void test1() {
        int k = 6;
        int[] tangerineArr = {1, 3, 2, 5, 4, 5, 2, 3};

        Tangerine tangerine = new Tangerine(k ,tangerineArr);
        int result = tangerine.typeCount();

        assertThat(result).isEqualTo(3);
    }
    @DisplayName("")
    @Test
    void test2() {
        int k = 4;
        int[] tangerineArr = {1, 3, 2, 5, 4, 5, 2, 3};

        Tangerine tangerine = new Tangerine(k ,tangerineArr);
        int result = tangerine.typeCount();

        assertThat(result).isEqualTo(2);
    }
    @DisplayName("")
    @Test
    void test3() {
        int k = 2;
        int[] tangerineArr = {1, 1, 1, 1, 2, 2, 2, 3};

        Tangerine tangerine = new Tangerine(k ,tangerineArr);
        int result = tangerine.typeCount();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("")
    @Test
    void test4() {
        int k = 2;
        int[] tangerineArr = {1000, 1000, 1000, 1000};

        Tangerine tangerine = new Tangerine(k ,tangerineArr);
        int result = tangerine.typeCount();

        assertThat(result).isEqualTo(1);
    }
}
