package com.example.tddexample.inflearn.part1.algorithm_5_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IronBarTest {

    /**
     * ()(((()())(())()))(())
     * () ( ( (()()) (()) () ) ) (())
     * ()(((()())(())()))(())
     * ((()))
     */

    @DisplayName("열고 닫는 괄호가 연속으로 오는 한쌍이면 레이저 이다.")
    @Test
    void test1() {
        IronBar ironBar = new IronBar();
        int result = ironBar.amputation("(()())");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void test2() {
        IronBar ironBar = new IronBar();
        int result = ironBar.amputation("()(((()())(())()))(())");

        assertThat(result).isEqualTo(17);
    }
}
