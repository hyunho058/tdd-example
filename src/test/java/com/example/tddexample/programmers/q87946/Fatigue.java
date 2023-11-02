package com.example.tddexample.programmers.q87946;

public class Fatigue {
    private final int k;
    private final int[][] dungeons;
    private final int[] visited;
    private int result = 0;

    public Fatigue(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        this.visited = new int[dungeons.length];
    }

    public int maxExploration(int fatigue) {
        dfs(0, fatigue);

        return result;
    }

    public void dfs(int level, int fatigue) {
        if (fatigue == 0) {
            return;
        }

        if (result < level) {
            result = level;
        }

        for (int i = 0; i < dungeons.length; i++) {
            int minimum = dungeons[i][0];
            int exhaustion = dungeons[i][1];

            if (fatigue < minimum) {
                continue;
            }

            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            dfs(level + 1, fatigue - exhaustion);
            visited[i] = 0;
        }
    }
}
