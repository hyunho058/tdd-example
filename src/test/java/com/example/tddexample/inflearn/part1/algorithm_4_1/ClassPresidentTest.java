package com.example.tddexample.inflearn.part1.algorithm_4_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ClassPresidentTest {

    /**
     * 1.학급회장 후보 A B C D E 5명 중 한명이 당선 된다.
     * 2.반 학생수 N명이 투표한 결과중 가장 많이 득표를 얻은 후보가 당선
     * 3.토표 리스트에서 각 후보가 받은 득표 수를 구한다.
     * 4.득표수중 가장 많이 받은 후보를 찾는다.
     */
    @DisplayName("A가 2표 B가 한표를 받아 A가 당선")
    @Test
    void test1() {
        ClassPresident classPresident = new ClassPresident();
        String result = classPresident.elected("ABA");

        assertThat(result).isEqualTo("A");
    }

    @DisplayName("가장 많은 득표를 받은 후보는 C 이다.")
    @Test
    void test2() {
        ClassPresident classPresident = new ClassPresident();
        String result = classPresident.elected(
            "BACBACCACCBDEDE"
        );

        assertThat(result).isEqualTo("C");
    }
}
