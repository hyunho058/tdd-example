package com.example.tddexample.inflearn.part2.hash.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mail {

    //    String[] reports = {
//            "john 09:00 in",
//            "john 10:10 out",
//    };
//    int time = 60;
    public String[] solution(String[] reports, int time) {
        Map<String, Integer> enterTimeMap = new HashMap<>();
        Map<String, Integer> accessMap = new HashMap<>();

        for (String report : reports) {
            String[] information = report.split(" ");
            String visitor = information[0];
            String timeStr = information[1];
            String accessStatus = information[2];
            int minute = this.timeToMinute(timeStr);

            if (accessStatus.equals("in")) {
                enterTimeMap.put(visitor, minute);
                continue;
            }

            int enterTime = enterTimeMap.get(visitor);
            int accessTime = minute - enterTime;

            accessMap.put(
                visitor,
                accessMap.getOrDefault(visitor, 0) + accessTime
            );

            enterTimeMap.remove(visitor);

        }

        List<String> overuses = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : accessMap.entrySet()) {
            Integer accessTime = entry.getValue();
            if (accessTime <= time) {
                continue;
            }

            String visitor = entry.getKey();
            overuses.add(visitor);
        }
        overuses.sort(Comparator.naturalOrder());;
        String[] answer = new String[overuses.size()];
        for (int i = 0; i < overuses.size(); i++) {
            answer[i] = overuses.get(i);
        }
        return answer;
    }

    private int timeToMinute(String timeStr) {
        String[] time = timeStr.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        return (hour * 60) + minute;
    }

    public static void main(String[] args) {
        Mail T = new Mail();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
