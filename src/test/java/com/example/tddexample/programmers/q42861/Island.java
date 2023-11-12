package com.example.tddexample.programmers.q42861;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Island {
    private final int n;
    private final int[][] coasts;
    private final int[] unf;
    private final List<Edge> edgeList = new ArrayList<>();

    public Island(int n, int[][] coasts) {
        this.n = n;
        this.coasts = coasts;
        this.unf = new int[n];
    }

    public int minCost() {
        for (int i = 1; i < unf.length ; i++) {
            unf[i] = i;
        }

        for (int[] costInfo : coasts) {
            int from = costInfo[0];
            int destination = costInfo[1];
            int cost = costInfo[2];

            edgeList.add(new Edge(from, destination, cost));
        }

        Collections.sort(edgeList);

        int totalCoast = 0;
        for (Edge edge : edgeList) {
            int cost = union(edge);
            totalCoast += cost;
        }

        return totalCoast;
    }

    public int find(int v) {
        if (v == unf[v]) {
            return v;
        }

        return unf[v] = find(unf[v]);
    }


    public int union(Edge edge) {
        int islandNumberA = find(edge.getFrom());
        int isLandNumberB = find(edge.getDestination());

        System.out.println(islandNumberA +" " +isLandNumberB);
        if (islandNumberA != isLandNumberB) {
            unf[islandNumberA] = isLandNumberB;
            return edge.getCost();
        }

        return 0;
    }


    protected static class Edge implements Comparable<Edge> {
        private final int from;
        private final int destination;
        private final int cost;

        public Edge(int from, int destination, int cost) {
            this.from = from;
            this.destination = destination;
            this.cost = cost;
        }

        public int getFrom() {
            return from;
        }

        public int getDestination() {
            return destination;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                "from=" + from +
                ", destination=" + destination +
                ", cost=" + cost +
                '}';
        }
    }
}
