package com.example.tddexample.programmers.q12985;

public class TableSchedule {
    private final int n;
    private int userA;
    private int userB;

    public TableSchedule(int n, int userA, int userB) {
        this.n = n;
        this.userA = userA;
        this.userB = userB;
    }

    public int round() {
        int round = 0;

        while (userA != userB) {
            userA = this.nextRoundNumber(userA);
            userB = this.nextRoundNumber(userB);
            round ++;
        }

        return round;
    }

    private int nextRoundNumber(int userNumber) {
        int nextNum = userNumber / 2;
        int remainder = userNumber % 2 != 0 ? 1 : 0;

        return nextNum + remainder;
    }
}
