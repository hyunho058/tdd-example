package com.example.tddexample.programmers.q43105;

public class Triangle {
    private final int[][] triangleArr;

    public Triangle(int[][] triangleArr) {
        this.triangleArr = triangleArr;
    }

    public int maxSum() {
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 1; i < triangleArr.length; i++) {
            for (int j = 0; j < triangleArr[i].length; j++) {
                if (j == 0) {
                    int sum = triangleArr[i - 1][j] + triangleArr[i][j];
                    triangleArr[i][j] = sum;

                    if (maxNumber < sum) {
                        maxNumber = sum;
                    }

                    continue;
                }

                if (j == triangleArr[i].length - 1) {
                    int sum = triangleArr[i - 1][j - 1] + triangleArr[i][j];
                    triangleArr[i][j] = sum;

                    if (maxNumber < sum) {
                        maxNumber = sum;
                    }

                    continue;
                }

                int left = triangleArr[i - 1][j - 1];
                int right = triangleArr[i - 1][j];

                int max = Math.max(left, right);
                triangleArr[i][j] += max;

                if (maxNumber < triangleArr[i][j]) {
                    maxNumber = triangleArr[i][j];
                }
            }
        }

        return maxNumber;
    }
}
