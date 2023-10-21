package com.example.tddexample.inflearn.greedy.room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Assignment {
    private final int n;
    private final int[][] conferenceArr;
    private final List<Conference> conferenceList;

    public Assignment(int n, int[][] conferenceArr) {
        this.n = n;
        this.conferenceArr = conferenceArr;
        this.conferenceList = new ArrayList<>();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] conferenceArr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            conferenceArr[i][0] = startTime;
            conferenceArr[i][1] = endTime;
        }

        Assignment main = new Assignment(n, conferenceArr);
        System.out.println(main.greedy());
    }

    public int greedy() {
        for (int[] c : conferenceArr) {
            conferenceList.add(new Conference(c[0], c[1]));
        }
        Collections.sort(conferenceList);

        int conferenceCount = 0;
        int beforeEndTime = 0;
        for (Conference conference : conferenceList) {
            if (conference.getStartTime() < beforeEndTime) {
                continue;
            }

            beforeEndTime = conference.getEndTime();
            conferenceCount++;
        }

        return conferenceCount;
    }


    protected static class Conference implements Comparable<Conference> {
        private final int startTime;
        private final int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.endTime == o.endTime) {
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime ;
        }
    }
}
