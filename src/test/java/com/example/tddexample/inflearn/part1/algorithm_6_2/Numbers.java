package com.example.tddexample.inflearn.part1.algorithm_6_2;

import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        Numbers main = new Numbers();
        int[] result = main.sort(ints);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length - i; j++) {
                int leftNumber = numbers[j];
                int rightNumber = numbers[j + 1];

                if (leftNumber > rightNumber) {
                    numbers[j + 1] = leftNumber;
                    numbers[j] = rightNumber;
                }
            }
        }

        return numbers;
    }
}
