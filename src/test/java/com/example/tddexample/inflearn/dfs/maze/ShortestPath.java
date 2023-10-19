package com.example.tddexample.inflearn.dfs.maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
    private final int[][] paths;
    private final int[][] pathCounts;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private Queue<Point> queue;


    public ShortestPath(int[][] paths) {
        this.paths = paths;
        this.pathCounts = new int[paths.length][paths.length];
    }

    public int bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.getX() == paths.length - 1 && point.getY() == paths.length - 1) {
                return pathCounts[point.getX()][point.getY()];
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = point.getX() + dx[i];
                int nextY = point.getY() + dy[i];
                if (nextX < 0 || nextX > paths.length - 1 || nextY < 0 || nextY > paths.length - 1) {
                    continue;
                }

                if (paths[nextX][nextY] == 1) {
                    continue;
                }

                paths[nextX][nextY] = 1;
                queue.offer(new Point(nextX, nextY));
                pathCounts[nextX][nextY] = pathCounts[point.getX()][point.getY()] + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int[][] board = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        ShortestPath main = new ShortestPath(board);
        int result = main.bfs(0, 0);
        System.out.println(result);

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
    }
}
