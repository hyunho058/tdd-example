package com.example.tddexample.inflearn.dfs.combination;

public class Combination {

    private final int[][] visited;

    public Combination(int[][] visited) {
        this.visited = visited;
    }

    public int dfs(int n, int r) {
        if (visited[n][r] != 0) {
            return visited[n][r];
        }
        if (r == 0) {
            return 1;
        }
        if (n == r) {
            return 1;
        }

        int leftValue = dfs(n - 1, r - 1);
        int rightValue = dfs(n - 1, r);

        int sum = leftValue + rightValue;
        visited[n][r] = sum;

        return sum;
    }
}
