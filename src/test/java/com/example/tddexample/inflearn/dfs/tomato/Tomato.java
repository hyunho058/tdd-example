package com.example.tddexample.inflearn.dfs.tomato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    private final int[][] box;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private Queue<Point> queue;
    private int answer = 0;

    public Tomato(int[][] box) {
        this.box = box;
    }

    public int bfs() {
        queue = new LinkedList<>();
        for (int x = 0; x < box.length; x++) {
            for (int y = 0; y < box[x].length; y++) {
                if (box[x][y] == 1) {
                    queue.offer(new Point(x, y));
                }
            }
        }

        int amount = queue.size();
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            amount--;

            for (int i = 0; i < dx.length; i++) {
                int nextX = point.getX() + dx[i];
                int nextY = point.getY() + dy[i];

                if (nextX < 0 || nextX > box.length - 1 || nextY < 0 || nextY > box[0].length - 1) {
                    continue;
                }

                if (box[nextX][nextY] == -1 || box[nextX][nextY] == 1) {
                    continue;
                }

                box[nextX][nextY] = 1;
                queue.offer(new Point(nextX, nextY));
            }

            if (amount == 0) {
                amount = queue.size();
                answer++;
            }
        }

        for (int x = 0; x < box.length; x++) {
            for (int y = 0; y < box[x].length; y++) {
                if (box[x][y] == 0) {
                    return -1;
                }
            }
        }

        return answer - 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] board = new int[n][m];
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        Tomato main = new Tomato(board);
        int result = main.bfs();
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
