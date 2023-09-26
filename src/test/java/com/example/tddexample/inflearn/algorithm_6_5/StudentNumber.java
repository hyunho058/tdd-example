package com.example.tddexample.inflearn.algorithm_6_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        StudentNumber main = new StudentNumber();
        String result = main.checkDuplicates(ints);

        System.out.println(result);
    }
    public String checkDuplicates(int[] numbers) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i : numbers) {
            if (numberMap.get(i) != null) {
                return "D";
            }

            numberMap.put(i, numberMap.getOrDefault(i, 0) + 1);
        }

        return "U";
    }
}
