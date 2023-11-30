package com.example.tddexample.inflearn.part2.password;

import java.util.HashMap;
import java.util.Map;

public class Password {

    public int solution(int[] keypad, String password) {
        Map<Integer, int[]> padMap = new HashMap<>();

        for (int i = 0; i < keypad.length; i++) {
            int number = keypad[i];
            int[] position = {(i / 3), (i % 3)};
            padMap.put(number, position);
        }

        int answer = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            int currentNumber = Character.getNumericValue(password.charAt(i));
            int[] currentPosition = padMap.get(currentNumber);

            int nextNumber = Character.getNumericValue(password.charAt(i + 1));
            int[] nextPosition = padMap.get(nextNumber);

            if (isSameNumber(currentNumber, nextNumber)) {
                continue;
            }

            if (isNotOneStep(currentPosition, nextPosition)) {
                answer += 2;
                continue;
            }

            answer++;
        }

        return answer;
    }

    private boolean isSameNumber(int current, int next) {
        return current == next;
    }

    private boolean isNotOneStep(int[] current, int[] next) {
        int gapX = current[0] - next[0];
        if (gapX < 0) {
            gapX *= -1;
        }

        int gapY = current[1] - next[1];
        if (gapY < 0) {
            gapY *= -1;
        }

        if (gapX > 1 || gapY > 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Password T = new Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
