package com.example.tddexample.inflearn.algorithm_5_3;

import java.util.Stack;

public class ClawCrane {
    //1.2차원 배열에서 move가 가리키는 열에서 0이 아닌 숫자를 찾는다
    //2.stack에서 최상단 값과 찾은 값을 비교한다.
    // ㄴ비교후 값이 같으면 제거 or 값이 다르면 add
    public int dollsCount(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int move : moves) {
            int columnPosition = move - 1;

            for (int y = board.length - 1; y >= 0; y--) {
                int yValue = board[y][columnPosition];

                if (yValue == 0) {
                    continue;
                }

                if (!stack.isEmpty() && stack.peek() == yValue) {

                    stack.pop();
                    count += 2;

                    board[y][columnPosition] = 0;
                    break;
                }

                stack.push(yValue);
                board[y][columnPosition] = 0;
                break;
            }
        }

        return count;
    }
}
