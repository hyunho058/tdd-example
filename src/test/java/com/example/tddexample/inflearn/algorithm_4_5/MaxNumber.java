package com.example.tddexample.inflearn.algorithm_4_5;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class MaxNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        MaxNumber maxNumber = new MaxNumber();
        int result = maxNumber.find(k, arr);

        System.out.println(result);
    }

    public int find(int k, Integer[] ints) {
        TreeSet<Integer> sumSet = new TreeSet<>(Collections.reverseOrder());

        for (int i1 = 0; i1 < ints.length - 2; i1++) {
            for (int i2 = i1 + 1; i2 < ints.length - 1; i2++) {
                for (int i3 = i2 + 1; i3 < ints.length; i3++) {
                    int sum = ints[i1] + ints[i2] + ints[i3];

                    sumSet.add(sum);
                }
            }
        }

        int count = 0;

        for (int i : sumSet) {
            count++;
            if (count == k) {
                return i;
            }
        }

        return -1;
    }
}
