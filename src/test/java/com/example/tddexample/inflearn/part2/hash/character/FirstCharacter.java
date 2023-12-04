package com.example.tddexample.inflearn.part2.hash.character;

import java.util.HashMap;
import java.util.Map;

public class FirstCharacter {
    public int solution(String s) {
        Map<java.lang.Character, Integer> alphabetMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            int value = alphabetMap.getOrDefault(alphabet, 0) + 1;
            alphabetMap.put(alphabet, value);
        }

        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            Integer count = alphabetMap.get(alphabet);

            if (count == 1) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstCharacter T = new FirstCharacter();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
