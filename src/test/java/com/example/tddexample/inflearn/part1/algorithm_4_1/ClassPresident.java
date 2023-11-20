package com.example.tddexample.inflearn.part1.algorithm_4_1;

import java.util.*;
import java.util.stream.Collectors;

public class ClassPresident {
    public static void main(String[] args) {
        ClassPresident main = new ClassPresident();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String arr = scanner.next();
        System.out.println(main.elected(arr));
    }

    public String elected(String votes) {
        Map<String, Long> voteMap = Arrays.stream(votes.split(""))
            .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        return voteMap.keySet().stream()
            .max(Comparator.comparing(voteMap::get))
            .orElse("");
    }
}
