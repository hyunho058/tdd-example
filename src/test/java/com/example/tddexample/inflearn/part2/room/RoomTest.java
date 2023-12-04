package com.example.tddexample.inflearn.part2.room;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoomTest {
    @Test
    void testCase1() {
        int[] enter = {1, 2, 3, 4};
        int[] exit = {2, 4, 1, 3};

        Room room = new Room();
        int[] metCounts = room.solution(enter, exit);
        assertThat(metCounts).containsExactly(3, 1, 2, 2);
    }

    @Test
    void testCase2() {
        int[] enter = {1, 2, 5, 3, 4};
        int[] exit = {2, 3, 1, 4, 5};

        Room room = new Room();
        int[] metCounts = room.solution(enter, exit);
        assertThat(metCounts).containsExactly(3, 1, 2, 1, 3);
    }

    @Test
    void testCase3() {
        int[] enter = {1, 3, 2, 4, 5, 7, 6, 8};
        int[] exit = {2, 3, 5, 6, 1, 4, 8, 7};

        Room room = new Room();
        int[] metCounts = room.solution(enter, exit);
        assertThat(metCounts).containsExactly(6, 2, 2, 4, 2, 3, 4, 1);
    }

}
