package com.example.tddexample.inflearn.part2.seat;

import java.util.Arrays;

public class SeatNumber {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    private boolean[][] visited;

    public int[] solution(int c, int r, int k) {
        int totalCount = c * r;
        if (totalCount < k) {
            return new int[]{0, 0};
        }

        visited = new boolean[c + 1][r + 1];

        int count = 1;
        int x = 1;
        int y = 1;
        int direction = 0;
        visited[x][y] = true;

        while (count < k) {
            int nextX = x + dx[direction % 4];
            int nextY = y + dy[direction % 4];

            if (nextY > r || nextX > c || nextY < 1 || nextX < 1) {
                direction++;
                continue;
            }

            if (visited[nextX][nextY]) {
                direction++;
                continue;
            }

            x = nextX;
            y = nextY;
            visited[x][y] = true;
            count++;
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SeatNumber T = new SeatNumber();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
