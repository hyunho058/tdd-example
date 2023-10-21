package com.example.tddexample.inflearn.greedy.selector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SelectorTest {
    @DisplayName("")
    @Test
    void test() {
        int n = 5;
        int[][] person = {
            {172, 67},
            {183, 65},
            {180, 70},
            {170, 72},
            {181, 60}
        };

        Selector selector = new Selector(n, person);
        int result = selector.greedy();

        assertThat(result).isEqualTo(3);
    }
}