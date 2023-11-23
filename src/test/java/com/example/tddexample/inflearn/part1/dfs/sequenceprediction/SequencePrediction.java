package com.example.tddexample.inflearn.part1.dfs.sequenceprediction;

import java.util.Scanner;

public class SequencePrediction {
    private final int n;
    private final int f;
    private final int[] results;
    private final int[] combinations;
    private final int[] checked;
    private boolean flag = false;

    public SequencePrediction(int n, int f, int[] combinations) {
        this.n = n;
        this.f = f;
        this.results = new int[n];
        this.combinations = combinations;
        this.checked = new int[n + 1];
    }

    public void dfs(int l, int sum) {
        if (flag) {
            return;
        }

        if (l == n) {
            if (sum == f) {
                for (int i : results) {
                    System.out.print(i + " ");
                }
                flag = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (checked[i] == 1) {
                continue;
            }

            checked[i] = 1;
            results[l] = i;
            dfs(l + 1, sum + (combinations[l] * results[l]));
            checked[i] = 0;
        }

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int f=scanner.nextInt();
        int[] b=new int[n];
        int[]  p=new int[n];
        int[] ch=new int[n+1];

        SequencePrediction.Combination combination = new SequencePrediction.Combination(n);
        int[] combinations = combination.calcCombinations();

        SequencePrediction main = new SequencePrediction(n, f, combinations);
        main.dfs(0, 0);
    }


    protected static class Combination {
        private final int n;
        private final int[][] visited;

        public Combination(int n) {
            this.n = n;
            this.visited = new int[n + 1][n + 1];
        }

        public int[] calcCombinations() {
            int[] combinations = new int[n];

            for (int i = 0; i < n; i++) {
                combinations[i] = dfs(n - 1, i);
            }

            return combinations;
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
}
