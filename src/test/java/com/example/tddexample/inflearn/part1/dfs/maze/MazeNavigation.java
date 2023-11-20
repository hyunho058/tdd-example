package com.example.tddexample.inflearn.part1.dfs.maze;

public class MazeNavigation {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private final int[][] board;
    private int answer = 0;

    public MazeNavigation(int[][] board) {
        this.board = board;
    }

    public int getAnswer() {
        return answer;
    }

    //모든 경로 탐색
    public void dfs(int x, int y) {
        int size = board.length - 1;
        if (x == size && y == size) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX > size|| nextY < 0 || nextY > size) {
                continue;
            }

            if (board[nextX][nextY] == 1) {
                continue;
            }

            board[nextX][nextY] = 1;
            dfs(nextX, nextY);
            board[nextX][nextY] = 0;

        }
    }
}