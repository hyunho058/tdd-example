package com.example.tddexample.inflearn.part2.room;

import java.util.Arrays;

public class Room {

//enter = {0, 1, 4, 2, 3} / exit = {1, 2, 0, 3, 4}

//0 1 3 4 2

    //0 1 4 7 3
//6 2 5 8 9
    public int[] solution(int[] enterArr, int[] exitArr) {
        int[] enterIdx = new int[enterArr.length];
        int[] enterTimes = new int[enterArr.length];
        int[] exitTimes = new int[exitArr.length];

        for (int i = 0; i < enterArr.length; i++) {
            int people = enterArr[i];
            enterIdx[people - 1] = i;
        }

        //0초부터 시간 순으로 입실, 퇴실 시간을 구한다.
        int time = 0;
        int beforeIdx = 0;
        for (int exit : exitArr) {
            int exitIdx = exit - 1;
            int current = enterIdx[exitIdx];

            if (beforeIdx > current) {
                exitTimes[exitIdx] = time++;
                continue;
            }

            for (int j = beforeIdx; j <= current; j++) {
                int enter = enterArr[j] - 1;
                enterTimes[enter] = time++;
            }

            exitTimes[exitIdx] = time++;
            beforeIdx = current + 1;
        }


        ///입실, 퇴실 시간을 비교하여 겹치는 시간이 있으면 만난것으로 판단 한다.
        int[] answer = new int[enterArr.length];
        for (int i = 0; i < enterTimes.length; i++) {
            int count = 0;
            int enter = enterTimes[i];
            int exit = exitTimes[i];

            for (int j = 0; j < exitTimes.length; j++) {
                if (i == j) {
                    continue;
                }

                int comparisonEnter = enterTimes[j];
                int comparisonExit = exitTimes[j];

                if (comparisonEnter > exit || comparisonExit < enter) {
                    continue;
                }
                count++;
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Room T = new Room();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
