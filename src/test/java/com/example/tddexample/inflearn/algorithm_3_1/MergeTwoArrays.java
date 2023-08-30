package com.example.tddexample.inflearn.algorithm_3_1;

import java.util.Scanner;

public class MergeTwoArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        MergeTwoArrays main = new MergeTwoArrays();
        int[] result = main.merge(arr1, arr2);

        for (int i : result) {
            System.out.println(i+" ");
        }
    }
    public int[] merge(int[] arr1, int[] arr2) {
        int maxLength = arr1.length + arr2.length;
        int[] result = new int[maxLength];

        int arr1Idx = 0;
        int arr2Idx = 0;
        for (int i = 0; i < maxLength; i++) {
            if (arr1Idx >= arr1.length) {
                result[i] = arr2[arr2Idx];
                arr2Idx++;
                continue;
            }
            if (arr2Idx >= arr2.length) {
                result[i] = arr1[arr1Idx];
                arr1Idx++;
                continue;
            }

            if (arr1[arr1Idx] < arr2[arr2Idx]) {
                result[i] = arr1[arr1Idx];
                arr1Idx++;
                continue;
            }

            result[i] = arr2[arr2Idx];
            arr2Idx++;
        }

        return result;
    }
}
