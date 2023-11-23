package com.example.tddexample.inflearn.part1.greedy.wonderland;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wonderland {

    private final int v;
    private final int e;
    private final int[][] loads;
    private final int[] unf;
    private final List<Edge> edges;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int v = kb.nextInt();
        int e = kb.nextInt();

        int[][] loads = new int[e][3];
        for (int i = 0; i < e; i++) {
            int from = kb.nextInt();
            int destination = kb.nextInt();
            int cost = kb.nextInt();

            loads[i][0] = from;
            loads[i][1] = destination;
            loads[i][2] = cost;
        }

        Wonderland wonderland = new Wonderland(e, v, loads);
        int minCost = wonderland.getMinCost();

        System.out.println(minCost);
    }

    public Wonderland(int v, int e, int[][] loads) {
        this.v = v;
        this.e = e;
        this.loads = loads;
        this.unf = new int[e + 1];
        this.edges = new ArrayList<>();
    }

    public int getMinCost() {
        for (int i = 1; i <= e; i++) {
            unf[i] = i;
        }

        for (int[] load : loads) {
            int cityA = load[0];
            int cityB = load[1];
            int cost = load[2];
            edges.add(new Edge(cityA, cityB, cost));
        }
        Collections.sort(edges);

        int sum = 0;
        for (Edge edge : edges) {
            int cost = union(edge);
            sum += cost;
        }

        return sum;
    }

    public int find(int v) {
        if (v == unf[v]) {
            return v;
        }

        return unf[v] = find(unf[v]);
    }

    public int union(Edge edge) {
        int groupNumberA = find(edge.getFrom());
        int groupNumberB = find(edge.getDestination());

        if (groupNumberA != groupNumberB) {
            unf[groupNumberA] = groupNumberB;
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
    }
}
