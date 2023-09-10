package com.example.tddexample.inflearn.algorithm_4_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        FindAnagram main = new FindAnagram();
        int count = main.count(s, t);

        System.out.println(count);
    }
    public int count(String s, String t) {
        //map에 크기로 같은지 비교 가능
        Map<String, Long> controlGroupMap = Arrays.stream(t.split(""))
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<String, Long> experimentalGroupMap = new HashMap<>();

        for (int i = 0; i < t.length() - 1; i++) {
            String key = String.valueOf(s.charAt(i));
            experimentalGroupMap.put(
                key,
                experimentalGroupMap.getOrDefault(key, 0L) + 1
            );
        }

        int result = 0;
        int leftIdx = 0;
        for (int rightIdx = t.length() - 1; rightIdx < s.length(); rightIdx++) {

            String key = String.valueOf(s.charAt(rightIdx));
            experimentalGroupMap.put(
                key,
                experimentalGroupMap.getOrDefault(key, 0L) + 1
            );

            if (controlGroupMap.equals(experimentalGroupMap)) {
                result++;
            }

            //두 map을 비교후 s문자열의 leftIndex에 해당하는 key값의 value감소 후 값이 0이 되면 삭제한다.
            String deleteKey = String.valueOf(s.charAt(leftIdx++));
            experimentalGroupMap.put(
                deleteKey,
                experimentalGroupMap.get(deleteKey) - 1
            );

            if (experimentalGroupMap.get(deleteKey) == 0L) {
                experimentalGroupMap.remove(deleteKey);
            }

        }

        return result;
    }
}
