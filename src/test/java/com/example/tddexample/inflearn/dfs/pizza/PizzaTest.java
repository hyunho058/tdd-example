package com.example.tddexample.inflearn.dfs.pizza;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PizzaTest {

    //map을 순회하여 house, pizza 좌표 목록을 만든다.
    //pizz 목록에서 m개 만큼 선택될 경우의 수 목록을 제귀를 통해 구한다 (ex-0부터 5까지 중 4개 선택 {0,1,2,3})
    //위 에서 구해진 피자집 을 각 집마다 거리를 비교하여 최소 거리인 피자집을 찾아 거리 수를 더한다.
    @DisplayName("최소 피자배달 거리")
    @Test
    void test() {
        int n = 4;
        int m = 4;
        int[][] map = {
            {0, 1, 2, 0},
            {1, 0, 2, 1},
            {0, 2, 1, 2},
            {2, 0, 1, 2}
        };

        Pizza pizza = new Pizza(n, m, map);
        int result = pizza.minDistance();
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("(1,2)에서 (2,3)까지에 거리는 2 이다.")
    @Test
    void calc_distance() {
        Pizza.Point house = new Pizza.Point(2, 3);
        Pizza.Point store = new Pizza.Point(1, 2);

        int result = house.distance(store);

        assertThat(result).isEqualTo(2);
    }
}