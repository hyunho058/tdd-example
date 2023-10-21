package com.example.tddexample.inflearn.greedy.lecture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LectureTest {
    @DisplayName("강연 최대 수입료를 구한다.")
    @Test
    void test() {
        int n = 6;
        int[][] lectureArr = {
            {50, 2},
            {20, 1},
            {40, 2},
            {60, 3},
            {30, 3},
            {30, 1}
        };

        Lecture lecture = new Lecture(n, lectureArr);
        int result = lecture.greedy();

        assertThat(result).isEqualTo(150);
    }
}