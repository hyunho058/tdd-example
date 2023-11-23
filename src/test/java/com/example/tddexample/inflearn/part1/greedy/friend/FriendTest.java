package com.example.tddexample.inflearn.part1.greedy.friend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FriendTest {
    @DisplayName("친구 인가?")
    @Test
    void test() {
        int n = 9;
        int m = 7;
        int[][] arr = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 5},
            {6, 7},
            {7, 8},
            {8, 9}
        };


        Friend friend = new Friend(n, m, arr);
        String result = friend.find(3, 8);

        assertThat(result).isEqualTo("NO");
    }
}