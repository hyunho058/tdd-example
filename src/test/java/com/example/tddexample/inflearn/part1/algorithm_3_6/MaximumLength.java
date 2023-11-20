package com.example.tddexample.inflearn.part1.algorithm_3_6;

import java.util.Scanner;

public class MaximumLength {

    public static void main(String[] args) {
        MaximumLength main = new MaximumLength();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(main.transformation(k, arr));
    }

    public int transformation(int k, int[] binaryArr) {
        int leftIdx = 0;
        int maxLength = 0;
        int currentLength = 0;
        int convertibleCount = 0;

        for (int binary : binaryArr) {
            if (binary == 0) {
                convertibleCount++;
            }

            currentLength++;

            //0을 1로 변환할 수 있는 수 'n'을 초과하면 가장 처음 바꾼 0까지 찾으며 현재 길이 감소
            while (convertibleCount > k) {
                if (binaryArr[leftIdx++] == 0) {
                    convertibleCount--;
                }

                currentLength--;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

        }

        return maxLength;
    }
}
