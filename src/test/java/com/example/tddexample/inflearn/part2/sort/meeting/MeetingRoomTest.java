package com.example.tddexample.inflearn.part2.sort.meeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingRoomTest {
    @Test
    void testCase1() {
        int[][] meetings = {{0, 10}, {20, 25}, {5, 15}, {2, 5}};

        MeetingRoom room = new MeetingRoom();
        int minimum = room.minimum(meetings);

        assertThat(minimum).isEqualTo(2);
    }

    /**
     * {2, 5}
     *       {5, 15}
     *          {0, 10}
     *                   {20, 25}
     */

    @Test
    void test() {
        String testStr = "";

        String[] sprinted = testStr.split("-");

        System.out.println(sprinted.length);

        System.out.println(sprinted[0]);

        long l = 0;
        try {
            l = Long.parseLong(sprinted[0]) << 24;
        }catch (Exception e) {
            System.out.println(0);
        }


        System.out.println(l);
    }
}
