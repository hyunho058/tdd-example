package com.example.tddexample.inflearn.algoritm_3_5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NaturalNumberTest {

    @Test
    void case1() {
        NaturalNumber naturalNumber = new NaturalNumber(15);

        int result = naturalNumber.calc();

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        NaturalNumber naturalNumber = new NaturalNumber(20);

        int result = naturalNumber.calc();

        assertThat(result).isEqualTo(1);
    }
}



