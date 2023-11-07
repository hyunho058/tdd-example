package com.example.tddexample.programmers.q43162;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NetworkTest {

    @DisplayName("두대의 컴퓨터가 연결되어있지 않으면 두개의 네트워크가 필요하다.")
    @Test
    void test1() {
        int n = 2;
        int[][] computers = {
            {1, 0},
            {0, 1}
        };

        Network network = new Network(n ,computers);
        int result = network.count();

        Assertions.assertThat(result).isEqualTo(2);
    }

    @DisplayName("두대의 컴퓨터가 연결되어있으면 한개의 네트워크가 필요하다.")
    @Test
    void test2() {
        int n = 2;
        int[][] computers = {
            {1, 1},
            {1, 1}
        };

        Network network = new Network(n ,computers);
        int result = network.count();

        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("A와 B가 연결되어있고 B와 C가 연결되어 있으면, A,B,C 모드 연결되어 있으므로 네트워크는 한개만 필요하다.")
    @Test
    void test3() {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        Network network = new Network(n ,computers);
        int result = network.count();

        Assertions.assertThat(result).isEqualTo(1);
    }
    @DisplayName("")
    @Test
    void test4() {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        Network network = new Network(n ,computers);
        int result = network.count();

        Assertions.assertThat(result).isEqualTo(2);
    }
}