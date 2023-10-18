package com.example.tddexample.inflearn.dfs.examination;

import java.util.Scanner;

public class Examination {
    private final int m;
    private final int[][] examinationArr;
    private int result = 0;

    public Examination(int m, int[][] examinationArr) {
        this.m = m;
        this.examinationArr = examinationArr;
    }

    public void maxScore(int level, int sumScore, int sumTime) {
        if (sumTime > m) {
            return;
        }

        if (this.result < sumScore) {
            this.result = sumScore;
        }

        if (level == examinationArr.length) {
            return;
        }

        int score = examinationArr[level][0];
        int time = examinationArr[level][1];
        maxScore(level + 1, sumScore + score, sumTime + time);
        maxScore(level + 1, sumScore, sumTime);
    }

    public int result() {
        return this.result;
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
        Examination main = new Examination(m, arr);
        main.maxScore(0, 0, 0);
        System.out.println(main.result());
    }
}
