package com.example.tddexample.inflearn.dfs.examination;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExaminationTest {
    @Test
    void test() {
        int c = 20;
        int[][] examinationArr = {
            {10, 5},
            {25, 12},
            {15, 8},
            {6, 3},
            {7, 4}
        };
        Examination examination = new Examination(c, examinationArr);
        int level = 0;
        int sumScore = 0;
        int sumTime = 0;
        examination.maxScore(0, sumScore, sumTime);

        Assertions.assertThat(examination.result()).isEqualTo(41);
    }
}