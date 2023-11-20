package com.example.tddexample.inflearn.part1.algorithm_5_7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ClassPlanTest {

    @DisplayName("필수과목 순서대로 수업을 계획.")
    @Test
    void testCase1() {
        ClassPlan classPlan = new ClassPlan();
        String result = classPlan.available("CBA", "CBA");

        assertThat(result).isEqualTo("YES");
    }

    @DisplayName("필수과목 순서대로 수업을 계획화지 않으면 잘 못 설계된 수업계획 이다.")
    @Test
    void testCase2() {
        ClassPlan classPlan = new ClassPlan();
        String result = classPlan.available("CBA", "CAB");

        assertThat(result).isEqualTo("NO");
    }

    @DisplayName("계획한 수업에 필수과목 순서대로 수업이 계획 되었다.")
    @Test
    void testCase3() {
        ClassPlan classPlan = new ClassPlan();
        String result = classPlan.available("CBA", "CBDAGE");

        assertThat(result).isEqualTo("YES");
    }

    @DisplayName("계획한 수업에 필수과목 순서대로 수업이 계획되어 있지 않다.")
    @Test
    void testCase4() {
        ClassPlan classPlan = new ClassPlan();
        String result = classPlan.available("CBA", "CDAGBE");

        assertThat(result).isEqualTo("NO");
    }
}
