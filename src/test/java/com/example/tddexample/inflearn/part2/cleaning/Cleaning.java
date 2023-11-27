package com.example.tddexample.inflearn.part2.cleaning;

import java.util.Arrays;

public class Cleaning {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public int[] solution(int[][] board, int k) {

        int[] answer = new int[2];
        int time = 0;
        int positionX = 0;
        int positionY = 0;
        int direction = 0;

        while (time < k) {
            int nextX = positionX + dx[direction % 4];
            int nextY = positionY + dy[direction % 4];

            if (rotation(nextX, nextY, board)){
                time++;
                direction++;
                continue;
            }

            positionX = nextX;
            positionY = nextY;
            time++;

            answer[0] = nextY;
            answer[1] = nextX;
        }

        return answer;
    }

    private boolean rotation(int x, int y, int[][] board) {
        if (y >= board.length || y < 0 || x >= board[y].length || x < 0) {
            return true;
        }

        if (board[y][x] == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Cleaning T = new Cleaning();
        int[][] arr1 = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
