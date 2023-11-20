package com.example.tddexample.inflearn.part1.algorithm_3_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElements {

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

        CommonElements main = new CommonElements();
        List<Integer> result = main.getDuplicates(arr1, arr2);

        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    public List<Integer> getDuplicates(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int arr1Idx = 0;
        int arr2Idx = 0;

        while (arr1Idx < arr1.length && arr2Idx < arr2.length) {
            if (arr1[arr1Idx] < arr2[arr2Idx]) {
                arr1Idx++;
                continue;
            }

            if (arr1[arr1Idx] == arr2[arr2Idx]) {
                result.add(arr1[arr1Idx]);
                arr1Idx++;
                arr2Idx++;
                continue;
            }

            arr2Idx++;
        }

        return result;
    }

//    타임아웃
//    public List<Integer> getDuplicates(int[] arr1, int[] arr2) {
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//        List<Integer> result = new ArrayList<>();
//
//        for (int element : arr1) {
//            int samePosition = 0;
//
//            for (int j = samePosition; j < arr2.length; j++) {
//                if (element == arr2[j]) {
//                    result.add(element);
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }
}
