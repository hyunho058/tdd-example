package com.example.tddexample.inflearn.part1.dfs.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {

    private final int n;
    private final int m;
    private final int[][] map;
    private final int[] combination;
    private List<Point> houseList;
    private List<Point> pizzaStoreList;
    private List<Integer> distanceList;


    public Pizza(int n, int m, int[][] map) {
        this.n = n;
        this.m = m;
        this.map = map;
        this.combination = new int[m];
        this.houseList = new ArrayList<>();
        this.pizzaStoreList = new ArrayList<>();
        this.distanceList = new ArrayList<>();
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                map[i][j] = tmp;
            }
        }

        Pizza main = new Pizza(n, m, map);
        int answer = main.minDistance();
        System.out.println(answer);
    }

    public void init() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y] == 1) {
                    houseList.add(new Point(x, y));
                    continue;
                }

                if (map[x][y] == 2) {
                    pizzaStoreList.add(new Point(x, y));
                }
            }
        }
    }

    public void dfs(int l, int s) {
        if (l == m) {

            //하우스와 피자가게 조합간에 최단 거리를 구해야한다.
            // 그리고 최단거리 합산에 더한다.
            int sumDistance = 0;
            for (Point house : houseList) {
                int minDistance = Integer.MAX_VALUE;
                for (int i : combination) {
                    Point store = pizzaStoreList.get(i);

                    int result = house.distance(store);
                    if (minDistance > result) {
                        minDistance = result;
                    }
                }
                sumDistance += minDistance;
            }
            distanceList.add(sumDistance);

            return;
        }

        for (int i = s; i < pizzaStoreList.size(); i++) {
            combination[l] = i;
            dfs(l + 1, i + 1);
        }
    }

    public int minDistance() {
        init();
        dfs(0, 0);

        return distanceList.stream()
            .min(Integer::compare)
            .get();
    }

    protected static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int distance(Point store) {
            int distanceX = this.x - store.getX();
            int distanceY = this.y - store.getY();

            if (distanceX < 0) {
                distanceX *= -1;
            }

            if (distanceY < 0) {
                distanceY *= -1;
            }

            return distanceX + distanceY;
        }
    }
}
