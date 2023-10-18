package com.example.tddexample.inflearn.dfs.subset;


import java.util.Scanner;

public class Subset {
    private final int n;
    private final int[] numbers;
    private final int total;
    private boolean isSame = false;
    private String result = "NO";

    public Subset(int n, int[] numbers, int total) {
        this.n = n;
        this.numbers = numbers;
        this.total = total;
    }

    public void dfs(int level, int sum) {
        if (isSame) {
            return;
        }
        if (level == n) {
            if (total - sum == sum) {
                isSame = true;
                result = "YES";
            }
            return;
        }

        dfs(level + 1, sum + numbers[level]);
        dfs(level + 1, sum);
    }

    public String result() {
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            total += numbers[i];
        }

        Subset main = new Subset(n, numbers, total);
        main.dfs(0, 0);
        System.out.println(main.result());
    }
}
