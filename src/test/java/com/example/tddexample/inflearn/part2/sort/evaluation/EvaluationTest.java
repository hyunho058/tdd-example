package com.example.tddexample.inflearn.part2.sort.evaluation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluationTest {
    @Test
    void testCase1() {
        Evaluation evaluation = new Evaluation();
        int result = evaluation.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3);

        assertThat(result).isEqualTo(89);
    }

    @Test
    void testCase2() {
        Evaluation evaluation = new Evaluation();
        int result = evaluation.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4);

        assertThat(result).isEqualTo(88);
    }

    @Test
    void testCase3() {
        Evaluation evaluation = new Evaluation();
        int result = evaluation.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5);

        assertThat(result).isEqualTo(92);
    }
}
