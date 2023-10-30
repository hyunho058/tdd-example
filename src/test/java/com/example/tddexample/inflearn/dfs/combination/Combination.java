package com.example.tddexample.inflearn.dfs.combination;

import java.util.Scanner;

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

        int leftVale = dfs(n - 1, r - 1);
        int rightVale = dfs(n - 1, r);

        int sum = leftVale + rightVale;
        visited[n][r] = sum;

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        Combination main = new Combination(new int[n+1][r+1]);
        int result = main.dfs(n, r);

        System.out.println(result);
    }
}
