package com.example.tddexample.inflearn.dfs.RouteNavigation;

public class RouteNavigation {
    private final int destination;
    private final int[][] lines;
    private final boolean[] visited;
    private int answer = 0;

    public RouteNavigation(int destination, int[][] lines) {
        this.destination = destination;
        this.lines = lines;
        this.visited = new boolean[destination + 1];
    }

    public int dfs(int node) {
        if (node == destination) {
            answer++;
        }

        visited[node] = true;

        return 1;
    }
}
