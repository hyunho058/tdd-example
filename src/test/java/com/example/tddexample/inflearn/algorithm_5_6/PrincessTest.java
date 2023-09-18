package com.example.tddexample.inflearn.algorithm_5_6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrincessTest {
    @Test
    void test(){
        int numberOfPrinces = 8;
        int number = 3;

        Princess princess = new Princess();
        int result = princess.princeNumber(numberOfPrinces, number);

        assertThat(result).isEqualTo(7);
    }
}
