package com.example.tddexample.inflearn.part1.dfs.RouteNavigation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RouteNavigationTest {
    @DisplayName("1에서 2로 가는 경우의 수는 1이다.")
    @Test
    void test() {
        int n = 2;
        int[][] lines = new int[n + 1][n + 1];
        lines[1][2] = 1;

        RouteNavigation routeNavigation = new RouteNavigation(n, lines);

        int result = routeNavigation.dfs(1);

        assertThat(result).isEqualTo(1);
    }
}
