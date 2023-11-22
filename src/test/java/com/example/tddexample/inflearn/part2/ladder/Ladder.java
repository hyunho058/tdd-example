package com.example.tddexample.inflearn.part2.ladder;

import java.util.Arrays;

public class Ladder {
    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        char startAlphabet = 'A';
        for (int i = 0; i < n; i++) {
            answer[i] = startAlphabet++;
        }

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                int left = ladder[i][j] - 1;
                int right = ladder[i][j];

                char temp = answer[left];
                answer[left] = answer[right];
                answer[right] = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ladder T = new Ladder();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
