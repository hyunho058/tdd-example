package com.example.tddexample.inflearn.algorithm_3_4;

public class PartialSequence {

    public int calculate(int n, int m, int[] arr) {
        int result = 0;
        int leftIdx = 0;

        int sum = 0;

        for (int rightIdx = 0; rightIdx < n; rightIdx++) {
            sum += arr[rightIdx];

            if (sum == m) {
                result++;
            }

            while (sum > m) {
                sum -= arr[leftIdx++];

                if (sum == m) {
                    result++;
                }
            }
        }

        return result;
    }
}
