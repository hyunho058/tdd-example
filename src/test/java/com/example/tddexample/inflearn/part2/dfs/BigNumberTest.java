package com.example.tddexample.inflearn.part2.dfs;

import com.example.tddexample.test.airport.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BigNumberTest {

    @DisplayName("주어진 숫자 n 보다 큰 수중 가장 작은 수를 반환한다.")
    @Test
    void testCase1() {
        BigNumber bigNumber = new BigNumber();
        int result = bigNumber.solution(123);

        assertThat(result).isEqualTo(132);
    }

    @Test
    void testCase2() {
        BigNumber bigNumber = new BigNumber();
        int result = bigNumber.solution(20573);

        assertThat(result).isEqualTo(20735);
    }

    @DisplayName("숫자 조합중 자신보다 큰 다음수가 없으면 -1을 반환한다.")
    @Test
    void testCase3() {
        BigNumber bigNumber = new BigNumber();
        int result = bigNumber.solution(321);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void testCase4() {
        BigNumber bigNumber = new BigNumber();
        int result = bigNumber.solution(54312);

        assertThat(result).isEqualTo(54321);
    }
}