package com.example.tddexample.programmers.q43162;

public class Network {
    private final int n;
    private final int[][] computers;
    private final int[] checked;

    public Network(int n, int[][] computers) {
        this(n, computers, new int[n]);
    }

    public Network(int n, int[][] computers, int[] checked) {
        this.n = n;
        this.computers = computers;
        this.checked = checked;
    }

    public int count() {
        int networkCount = 0;
        for (int i = 0; i < n; i++) {

            if (checked[i] == 1) {
                continue;
            }

            dfs(i);
            networkCount++;
        }

        return networkCount;
    }

    private void dfs(int idx) {
        checked[idx] = 1;

        for (int i = 0; i < n; i++) {
            if (i == idx) continue;;
            if (checked[i] == 1) continue;
            if (computers[idx][i] == 0) continue;

            dfs(i);
        }
    }
}
