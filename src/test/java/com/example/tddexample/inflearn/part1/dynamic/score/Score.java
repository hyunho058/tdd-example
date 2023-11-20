package com.example.tddexample.inflearn.part1.dynamic.score;

import java.util.Scanner;

public class Score {
    private final int n;
    private final int timeLimit;
    private final int[][] problemArr;
    private final int[] dynamic;

    public Score(int n, int timeLimit, int[][] problemArr) {
        this.n = n;
        this.timeLimit = timeLimit;
        this.problemArr = problemArr;
        this.dynamic = new int[timeLimit + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Score score = new Score(n, m, arr);
        int result = score.maxScore();
        System.out.println(result);
    }

    public int maxScore() {
        int maxScore = 0;

        for (int[] problem : problemArr) {

            int score = problem[0];
            int time = problem[1];

            for (int j = timeLimit; j >= time; j--) {
                int sumScore = dynamic[j - time] + score;

                if (dynamic[j] < sumScore) {
                    dynamic[j] = sumScore;
                }

                if (maxScore < sumScore) {
                    maxScore = sumScore;
                }
            }
        }

        return maxScore;
    }
}
