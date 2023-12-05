package com.example.tddexample.inflearn.part2.hash.election;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Election {

    //Map<String, List<String>>
    //tom List.of(john, luis, daniel)
    //k번 이상 받은 받은  학생 찾는다.
    //선물 받은 수 map<String, Integer>
    public String solution(String[] votes, int k) {

        Map<String, List<String>> candidateMap = new HashMap<>();

        for (String vote : votes) {
            String[] information = vote.split(" ");
            String voter = information[0];
            String candidate = information[1];

            List<String> voters = candidateMap.getOrDefault(candidate, new ArrayList<>());
            voters.add(voter);
            candidateMap.put(candidate, voters);
        }

        Map<String, Integer> voterMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entity : candidateMap.entrySet()) {
            List<String> voters = entity.getValue();
            if (voters.size() < k) {
                continue;
            }

            for (String voter : voters) {
                voterMap.put(voter, voterMap.getOrDefault(voter, 0) + 1);
            }
        }

        return MaxCandidateProduction(voterMap);
    }

    private String MaxCandidateProduction(Map<String, Integer> voterMap) {
        int maxCount = Integer.MIN_VALUE;
        String answer = "";
        for (Map.Entry<String, Integer> entity : voterMap.entrySet()) {
            Integer value = entity.getValue();
            String voter = entity.getKey();

            if (maxCount > value) {
                continue;
            }

            if (maxCount < value) {
                maxCount = value;
                answer = voter;
                continue;
            }

            answer = highPriority(answer, voter);
        }
        return answer;
    }

    private String highPriority(String before, String current) {
        int result = before.compareTo(current);

        if (result > 0) {
            return current;
        }

        return before;
    }


    public static void main(String[] args) {
        Election T = new Election();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
