package com.example.tddexample.inflearn.algorithm_6_3;

import java.util.Scanner;

public class Insertion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        Insertion main = new Insertion();
        int[] result = main.sort(ints);

        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    public int[] sort(int[] ints) {

        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j >0; j--) {
                int temp = 0;

                if (ints[j-1] > ints[j]) {
                    temp = ints[j-1];
                    ints[j-1] = ints[j];
                    ints[j] = temp;
                    continue;
                }

                break;
            }
        }

        return ints;
    }
}
