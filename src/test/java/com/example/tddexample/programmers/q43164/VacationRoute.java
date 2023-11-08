package com.example.tddexample.programmers.q43164;

import java.util.PriorityQueue;
import java.util.Queue;

public class VacationRoute {
    private final String[][] tickets;
    private final int[] visited;
    private final Queue<String> routeQueue;

    public VacationRoute(String[][] tickets) {
        this(
            tickets,
            new int[tickets.length],
            new PriorityQueue<>()
        );
    }

    public VacationRoute(String[][] tickets, int[] visited, Queue<String> routeQueue) {
        this.tickets = tickets;
        this.visited = visited;
        this.routeQueue = routeQueue;
    }

    public String[] route() {

        dfs(0, "ICN", "ICN");

        String route = routeQueue.poll();

        return route.split(" ");
    }

    private void dfs(int level, String arrival, String route) {
        if (level == tickets.length) {
            routeQueue.offer(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String departure = tickets[i][0];
            String nextArrival = tickets[i][1];

            if (visited[i] == 1) {
                continue;
            }

            if (!arrival.equals(departure)) {
                continue;
            }

            System.out.println(departure + " " +nextArrival);
            visited[i] = 1;
            dfs(level+1, nextArrival, route + " " + nextArrival);
            visited[i] = 0;
        }
    }
}
