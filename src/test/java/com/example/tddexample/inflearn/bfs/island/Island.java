package com.example.tddexample.inflearn.bfs.island;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {

    private final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private final int[][] map;
    private Queue<Point> queue;
    private int amount = 0;

    public Island(int[][] map) {
        this.map = map;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Island T = new Island(arr);
        int result = T.bfs();
        System.out.println(result);
    }

    public int bfs() {
        queue = new LinkedList<>();
        //map을 순회 한다.
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y] == 0) {
                    continue;
                }

                amount++;
                //1로 발견된 값(섬)인접한 위치에 1을 확인하며, 없을때 까지 순회
                queue.offer(new Point(x, y));
                while (!queue.isEmpty()) {

                    Point point = queue.poll();

                    //포인트에 인접한 상,하,좌,우,대각선을 조회
                    for (int i = 0; i < dx.length; i++) {
                        int nextX = point.getX() + dx[i];
                        int nextY = point.getY() + dy[i];

                        if (nextX < 0 || nextX > map.length - 1 || nextY < 0 || nextY > map[0].length - 1) {
                            continue;
                        }

                        if (map[nextX][nextY] == 0) {
                            continue;
                        }

                        map[nextX][nextY] = 0;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }

        return amount;
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
