package com.example.tddexample.inflearn.dfs;

public class Recursion {
    private final int[] FibonacciNumbers;

    public Recursion(int n) {
        FibonacciNumbers = new int[n + 1];
    }

    public int fibonacci(int number) {
        if (FibonacciNumbers[number] != 0) {
            return FibonacciNumbers[number];
        }

        if (number == 1) {
            return FibonacciNumbers[number] = 1;
        } else if (number == 2) {
            return FibonacciNumbers[number] = 1;
        }

        int result = fibonacci(number - 2) + fibonacci(number - 1);
        FibonacciNumbers[number] = result;

        return result;
    }

    public int[] getFibonacciNumbers() {
        return FibonacciNumbers;
    }
}
