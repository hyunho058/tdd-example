package com.example.tddexample.inflearn.part2.greedy.people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class People {

    public int maximum(int n, int[][] trans, int[][] bookings) {
        int[] sum = new int[n + 1];

        for (int[] train : trans) {
            int from = train[0];
            int destination = train[1];
            int passengers = train[2];수

            sum[from] += passengers;
            sum[destination] -= passengers;
        }

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }

        List<Booking> bookingList = new ArrayList<>();
        for (int[] booking : bookings) {
            bookingList.add(new Booking(booking));
        }
        Collections.sort(bookingList);

        int maximumPassenger = 0;
        LinkedList<Integer> passengers = new LinkedList<>();
        for (int station = 1; station <= n; station++) {
            //하차
            for (int i = 0; i < passengers.size(); i++) {
                if (station == passengers.get(i)) {
                    passengers.pollFirst();
                    maximumPassenger++;
                    i--;
                }
            }

            //승차
            for (Booking booking : bookingList) {
                if (station < booking.getFrom()) {
                    break;
                }

                if (station == booking.getFrom()) {
                    passengers.add(booking.getDestination());
                }
            }

            Collections.sort(passengers);

            //거절
            while (sum[station] < passengers.size()) {
                passengers.pollLast();
            }
        }
        return maximumPassenger;
    }

    protected static class Booking implements Comparable<Booking> {
        private final int from;
        private final int destination;

        public Booking(int[] bookingArr) {
            this(bookingArr[0], bookingArr[1]);
        }

        public Booking(int from, int destination) {
            this.from = from;
            this.destination = destination;
        }

        @Override
        public int compareTo(Booking o) {
            return this.from - o.getFrom();
        }

        public int getFrom() {
            return from;
        }

        public int getDestination() {
            return destination;
        }
    }
}
