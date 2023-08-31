package com.example.tddexample.inflearn.algorithm_3_4;

import java.util.Scanner;

public class PartialSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        PartialSequence main = new PartialSequence();
        int result = main.calculate(n, m, arr);
        System.out.print(result);
    }

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
