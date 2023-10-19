package com.example.tddexample.inflearn.dfs.sequenceprediction;

public class SequencePrediction {
    private final int n;
    private final int f;
    private final int[] results;
    private final int[] combinations;
    private final int[] checked;

    public SequencePrediction(int n, int f, int[] combinations) {
        this.n = n;
        this.f = f;
        this.results = new int[n];
        this.combinations = combinations;
        this.checked = new int[n + 1];
    }

    public void dfs(int l, int number, int sum) {
//        System.out.println("------------------------------");
//        System.out.println("l = " + l);

        int result = sum + (combinations[l] * number);
//        System.out.println("sum = " + sum);
//        System.out.println("combinations[l] : " + combinations[l] + " / number :" + number);
//        System.out.println("result = " + result);

        if (l == n) {
            if (result == f) {
                for (int i = 0; i < n; i++) {
                    System.out.print(results[i] + " ");
                }
                System.out.println(" ");
            }
            return;
        }

        if (result >= f) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (checked[i] == 1) {
                continue;
            }

            checked[i] = 1;
            results[l] = i;
            if (l < n) {
                dfs(l + 1, i, result);
            }
            checked[i] = 0;

        }
    }


    protected static class Combination {
        private final int n;
        private final int[][] visited;

        public Combination(int n) {
            this.n = n;
            this.visited = new int[n + 1][n + 1];
        }

        public int[] calcCombinations() {
            int[] combinations = new int[n + 1];

            for (int i = 0; i < n; i++) {
                combinations[i + 1] = dfs(n - 1, i);
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
