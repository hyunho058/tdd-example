package com.example.tddexample.inflearn.part2.hash.rate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlphabetRateTest {

    @DisplayName("a,b,c,d,e 알파벳이 문자열에 동일한 개수로 사용되어 있으면 모두 0이다.")
    @Test
    void sameQuantityOfUsage() {
        String s = "aabbccddee";

        AlphabetRate rate = new AlphabetRate();
        int[] rateArr = rate.solution(s);

        assertThat(rateArr).containsExactly(0, 0, 0, 0, 0);
    }

    @DisplayName("a가 3개만 존재하는 문자열에 비율을 맞추려면 나머지 b,c,d,e 는 3개씩 필요하다.")
    @Test
    void test() {
        String s = "aaa";

        AlphabetRate rate = new AlphabetRate();
        int[] rateArr = rate.solution(s);

        assertThat(rateArr).containsExactly(0, 3, 3, 3, 3);
    }

    @Test
    void testCate1() {
        String s = "aaabc";

        AlphabetRate rate = new AlphabetRate();
        int[] rateArr = rate.solution(s);

        assertThat(rateArr).containsExactly(0, 2, 2, 3, 3);
    }

    @Test
    void testCate2() {
        String s = "abcdeabc";

        AlphabetRate rate = new AlphabetRate();
        int[] rateArr = rate.solution(s);

        assertThat(rateArr).containsExactly(0, 0, 0, 1, 1);
    }
}
