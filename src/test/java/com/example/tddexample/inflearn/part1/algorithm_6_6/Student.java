package com.example.tddexample.inflearn.part1.algorithm_6_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = scanner.nextInt();
        }

        Student student = new Student();
        List<Integer> result = student.find(ints);

        System.out.println(result.get(0) + " " + result.get(1));
    }

    public List<Integer> find(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        int[] orderByAsc = numbers.clone();
        Arrays.sort(orderByAsc);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != orderByAsc[i]) {
                result.add(i + 1);
            }

            if (result.size() > 1){
                break;
            }
        }

        return result;
    }
}
