package com.example.tddexample.inflearn.dynamic.sequence;

import java.util.Scanner;

public class IncrementSequence {
    private final int n;
    private final int[] numbers;
    private final int[] dy;

    public IncrementSequence(int n, int[] numbers) {
        this.n = n;
        this.numbers = numbers;
        this.dy = new int[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        IncrementSequence main = new IncrementSequence(n, arr);
        int result = main.lis();

        System.out.println(result);
    }

    public int lis() {
        int answer = 0;
        dy[0] = 1;

        for (int i = 1; i < n; i++) {
            int currentNumber = numbers[i];

            for (int j = i; j >= 0; j--) {
                if (isLarge(currentNumber, numbers[j])) {
                    continue;
                }

                dy[i] = Math.max(dy[i], dy[j] + 1);
            }

            if (this.isZero(dy[i])) {
                dy[i] = 1;
            }

            if (isLarge(answer, dy[i])) {
                answer = dy[i];
            }
        }

        return answer;
    }

    private boolean isLarge(int a, int b) {
        return a < b;
    }

    private boolean isZero(int number) {
        return number == 0;
    }

}
