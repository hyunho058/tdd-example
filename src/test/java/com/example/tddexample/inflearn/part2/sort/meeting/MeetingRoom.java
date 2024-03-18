package com.example.tddexample.inflearn.part2.sort.meeting;

public class MeetingRoom {
    public int minimum(int[][] meetings){
        int answer = 0;

        return answer;
    }

    public static void main(String[] args){
        MeetingRoom T = new MeetingRoom();
        System.out.println(T.minimum(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.minimum(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.minimum(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.minimum(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
