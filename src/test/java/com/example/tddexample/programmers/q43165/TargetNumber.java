package com.example.tddexample.programmers.q43165;

public class TargetNumber {
    private final int target;
    private final int[] numbers;
    private int count;

    public TargetNumber(int target, int[] numbers) {
        this.target = target;
        this.numbers = numbers;
        this.count = 0;
    }

    private void dfs(int idx, int sum) {
        int size = numbers.length;

        if (idx >= size && sum == target) {
            count ++;
        }

        if (idx >= size) {
            return;
        }

        int number = numbers[idx];

        dfs(idx + 1, sum + number);
        dfs(idx + 1, sum - number);
    }

    public int numberOfCases(int idx, int sum) {
        this.dfs(idx, sum);
        return this.count;
    }
}
