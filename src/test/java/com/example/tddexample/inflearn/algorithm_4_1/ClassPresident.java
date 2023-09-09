package com.example.tddexample.inflearn.algorithm_4_1;

import java.util.*;
import java.util.stream.Collectors;

public class ClassPresident {
    public static void main(String[] args) {
        ClassPresident main = new ClassPresident();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String arr = scanner.next();
        System.out.println(main.elected(n, arr));
    }

    public String elected(int n, String votes) {
        Map<String, Integer> voteMap = new HashMap<>();

        for (char vote : votes.toCharArray()) {
            String key = String.valueOf(vote);
            voteMap.put(key, voteMap.getOrDefault(key, 0) + 1);
        }

        String president = "";
        long maxCount = 0;

        for (String vote : voteMap.keySet()){
            if (maxCount < voteMap.get(vote)) {
                president = vote;
                maxCount = voteMap.get(vote);
            }
        }

        return president;
    }
}
