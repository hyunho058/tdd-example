package com.example.tddexample.inflearn.part2.sort.selectcard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardGameTest {
    @Test
    void testCase1() {
        CardGame cardGame = new CardGame();
        int result = cardGame.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2);

        assertThat(result).isEqualTo(28);
    }

    @Test
    void testCase2() {
        CardGame cardGame = new CardGame();
        int result = cardGame.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2);

        assertThat(result).isEqualTo(34);
    }
}