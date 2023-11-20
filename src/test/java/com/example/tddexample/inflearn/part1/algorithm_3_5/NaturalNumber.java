package com.example.tddexample.inflearn.part1.algorithm_3_5;

import java.util.Scanner;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        this.number = number;
    }

    public int calc() {
        int result = 0;
        int idx = this.getStartPosition();
        int p2 = 1;

        int sum = p2;

        for (int p1 = 2; p1 <= idx; p1++) {
            sum += p1;

            if (sum == this.number) {
                result++;
                sum -= p2++;
            }

            while (sum > this.number) {
                sum -= p2++;

                if (sum == this.number) {
                    result++;
                }
            }

        }

        return result;
    }

    private int getStartPosition() {
        int startPosition = number / 2;

        if (number % 2 != 0) {
            startPosition += 1;
        }

        return startPosition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        NaturalNumber main = new NaturalNumber(n);
        System.out.print(main.calc());
    }
}
