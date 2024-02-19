package com.example.tddexample.inflearn.part2.greedy.battle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BattleTest {

    @Test
    void testCase1() {
        String[] strings = {"a 20", "b 12", "a 10", "c 11", "e 12"};
        Battle battle = new Battle();
        int[] results = battle.solution(strings);

        assertThat(results).containsExactly(35, 21, 0, 10, 21);
    }

    @Test
    void testCase2() {
        String[] strings = {"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"};
        Battle battle = new Battle();
        int[] results = battle.solution(strings);

        assertThat(results).containsExactly(35, 21, 0, 10, 38, 59, 21);
    }

    @Test
    void testCase3() {
        String[] strings = {"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"};
        Battle battle = new Battle();
        int[] results = battle.solution(strings);

        assertThat(results).containsExactly(15, 23, 82, 0, 15, 82, 0);
    }

    @Test
    void testCase4() {
        String[] strings = {"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"};
        Battle battle = new Battle();
        int[] results = battle.solution(strings);

        assertThat(results).containsExactly(45, 20, 20, 0, 0, 20, 75);
    }
}
