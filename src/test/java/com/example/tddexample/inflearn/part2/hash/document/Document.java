package com.example.tddexample.inflearn.part2.hash.document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Document {
    public List<String> solution(String[] reports, String times) {
        List<Enter> enters = new ArrayList<>();

        for (String report : reports) {
            String[] information = report.split(" ");
            String visitor = information[0];
            Time enterTime = this.transformationTime(information[1]);
            enters.add(new Enter(visitor, enterTime));
        }
        Collections.sort(enters);

        String[] lostInformation = times.split(" ");
        Time startTime = this.transformationTime(lostInformation[0]);
        Time endTime = this.transformationTime(lostInformation[1]);
        Lost lost = new Lost(startTime, endTime);

        List<String> result = new ArrayList<>();
        for (Enter enter : enters) {
            if (endTime.isBefore(enter.getTime())) {
                break;
            }

            if (lost.contain(enter.getTime())) {
                result.add(enter.getVisitor());
            }
        }

        return result;
    }

    private Time transformationTime(String time) {
        String[] timeArr = time.split(":");
        String hour = timeArr[0];
        String minute = timeArr[1];

        return new Time(hour, minute);
    }

    protected static class Enter implements Comparable<Enter> {
        private final String visitor;
        private final Time time;

        public Enter(String visitor, Time time) {
            this.visitor = visitor;
            this.time = time;
        }

        public String getVisitor() {
            return visitor;
        }

        public Time getTime() {
            return time;
        }

        @Override
        public int compareTo(Enter o) {
            if (this.time.getHour() == o.time.getHour()) {
                return this.time.getMinute() - o.time.getMinute();
            }
            return this.time.getHour() - o.time.getHour();
        }
    }

    protected static class Lost {
        private final Time start;
        private final Time end;

        public Lost(Time start, Time end) {
            this.start = start;
            this.end = end;
        }

        public boolean contain(Time time) {
            if (start.isAfter(time)) {
                return false;
            }

            if (end.isBefore(time)) {
                return false;
            }

            return true;
        }
    }

    protected static class Time {
        private final int hour;
        private final int minute;

        public Time(String hour, String minute) {
            this(
                    Integer.parseInt(hour),
                    Integer.parseInt(minute)
            );
        }

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public boolean isBefore(Time time) {
            if (this.hour < time.getHour()) {
                return true;
            }

            if (this.hour > time.getHour()) {
                return false;
            }

            if (this.minute < time.getMinute()) {
                return true;
            }

            return false;
        }

        public boolean isAfter(Time time) {
            if (this.hour > time.getHour()) {
                return true;
            }

            if (this.hour < time.getHour()) {
                return false;
            }

            if (this.minute > time.getMinute()) {
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Document T = new Document();
//        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
//        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
//        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
