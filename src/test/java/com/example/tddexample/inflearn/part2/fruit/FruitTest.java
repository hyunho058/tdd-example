package com.example.tddexample.inflearn.part2.fruit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FruitTest {
    @DisplayName("적게 가지고 있는 과일수가 중복 이면 교환하지 않는다.")
    @Test
    void duplicateMinimum() {
        Fruit fruit = new Fruit();
        int[][] fruitArr = {
            {10, 20, 10},
            {11, 5, 20}
        };

        int result = fruit.solution(fruitArr);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("두 학생이 적게 가지고 과일이 동일하면 교환하지 않는다.")
    @Test
    void sameMinFruitIndex() {
        Fruit fruit = new Fruit();
        int[][] fruitArr = {
            {10, 20, 13},
            {5, 13, 15}
        };

        int result = fruit.solution(fruitArr);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("과일을 교환하고 최솟값은 동일하고 과일 종류만 바뀐 경우 이득이 되지 않기때문에 교환하지 않는다.")
    @Test
    void notGain() {
        Fruit fruit = new Fruit();
        int[][] fruitArr = {
            {10, 9, 11},
            {15, 20, 25}
        };

        int result = fruit.solution(fruitArr);
        assertThat(result).isEqualTo(24);
    }

    @Test
    void testCase1() {
        Fruit fruit = new Fruit();
        int[][] fruitArr = {
            {10, 20, 30},
            {12, 15, 20},
            {20, 12, 15},
            {15, 20, 10},
            {10, 15, 10}
        };

        int result = fruit.solution(fruitArr);
        assertThat(result).isEqualTo(58);
    }

    @Test
    void testCase2() {
        Fruit fruit = new Fruit();
        int[][] fruitArr = {
            {0, 3, 27},
            {20, 5, 5},
            {19, 5, 6},
            {10, 10, 10},
            {15, 10, 5},
            {3, 7, 20}
        };

        int result = fruit.solution(fruitArr);
        assertThat(result).isEqualTo(32);
    }

    @Test
    void testCase3() {
        Fruit fruit = new Fruit();
        int[][] fruitArr = {
            {3, 7, 20},
            {10, 15, 5},
            {19, 5, 6},
            {10, 10, 10},
            {15, 10, 5},
            {3, 7, 20},
            {12, 12, 6},
            {10, 20, 0},
            {5, 10, 15}
        };

        int result = fruit.solution(fruitArr);
        assertThat(result).isEqualTo(48);
    }
}
