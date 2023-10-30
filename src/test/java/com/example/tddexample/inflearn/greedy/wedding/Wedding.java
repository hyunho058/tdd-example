package com.example.tddexample.inflearn.greedy.wedding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wedding {
    private final int n;
    private final int[][] scheduleArr;
    private final List<Schedule> schedules;

    public Wedding(int n, int[][] scheduleArr) {
        this.n = n;
        this.scheduleArr = scheduleArr;
        this.schedules = new ArrayList<>();
    }

    public int greedy() {
        for (int[] s : scheduleArr) {
            schedules.add(new Schedule(s[0], 's'));
            schedules.add(new Schedule(s[1], 'e'));
        }

        Collections.sort(schedules);

        int count = 0;
        int participationCount = 0;

        for (Schedule schedule : schedules) {
            System.out.println("schedule = " + schedule.toString());
            if (schedule.status == 's') {
                count++;
            } else {
                count--;
            }

            if (count > participationCount) {
                participationCount = count;
            }
        }

        return participationCount;
    }

    protected static class Schedule implements Comparable<Schedule> {
        private final int time;
        private final char status;

        public Schedule(int time, char status) {
            this.time = time;
            this.status = status;
        }

        public int getTime() {
            return time;
        }

        public char getStatus() {
            return status;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.time == o.time) {
                return this.status - o.status;
            }
            return this.time - o.time;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                "time=" + time +
                ", status=" + status +
                '}';
        }
    }
}
