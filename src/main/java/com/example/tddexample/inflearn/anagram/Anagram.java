package com.example.tddexample.inflearn.anagram;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        Anagram main = new Anagram();
        String result = main.anagram(s1, s2);
        System.out.println(result);
    }
    public String anagram(String s1, String s2) {
        if (isNOtSameLength(s1, s2)) {
            return "NO";
        }

        Map<String, Long> firstSCharacterMap = toMap(s1);
        Map<String, Long> secondCharacterMap = toMap(s2);

        for (String key : firstSCharacterMap.keySet()) {
            Long alphabetCount1 = firstSCharacterMap.get(key);
            Long alphabetCount2 = secondCharacterMap.get(key);

            if (!Objects.equals(alphabetCount1, alphabetCount2)) {
                return "NO";
            }
        }


        return "YES";
    }

    private boolean isNOtSameLength(String s1, String s2) {
        return s1.length() != s2.length();
    }

    private Map<String, Long> toMap(String s) {
        return Arrays.stream(s.split("")).
            collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}