package com.example.tddexample.inflearn.part1.greedy.lecture;

import java.util.*;

public class Lecture {

    private final int n;
    private final int[][] lectureArr;
    private final List<Schedule> schedules;
    private int maxDays = 0;

    public Lecture(int n, int[][] lectureArr) {
        this.n = n;
        this.lectureArr = lectureArr;
        this.schedules = new ArrayList<>();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            arr[i][0] = m;
            arr[i][1] = d;
        }

        Lecture main = new Lecture(n, arr);
        System.out.println(main.greedy());
    }

    public int greedy() {
        for (int[] l : lectureArr) {
            int money = l[0];
            int day = l[1];

            if (maxDays < day) {
                maxDays = day;
            }

            schedules.add(new Schedule(money, day));
        }

        Collections.sort(schedules);

        PriorityQueue<Integer> scheduleQueue = new PriorityQueue<>(Collections.reverseOrder());
        int totalMoney = 0;
        int idx = 0;

        for (int day = maxDays; day >= 1; day--) {
            for (int i = idx; i < schedules.size(); i++) {
                if (schedules.get(i).getDay() < day) {
                    idx = i;
                    break;
                }

                scheduleQueue.offer(schedules.get(i).getMoney());
            }

            if (!scheduleQueue.isEmpty()) {
                Integer money = scheduleQueue.poll();
                totalMoney += money;
            }

        }

        return totalMoney;
    }


    protected static class Schedule implements Comparable<Schedule> {
        private final int money;
        private final int day;

        public Schedule(int money, int day) {
            this.money = money;
            this.day = day;
        }

        public int getMoney() {
            return money;
        }

        public int getDay() {
            return day;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.day - this.day;
        }
    }
}
