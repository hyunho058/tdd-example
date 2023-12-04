package com.example.tddexample.inflearn.part2.hash.rate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlphabetRate {
    public int[] solution(String s) {
        Map<Character, Integer> alphabetMap = new HashMap<>();

        int maxQuantity = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            int value = alphabetMap.getOrDefault(alphabet, 0) + 1;
            alphabetMap.put(alphabet, value);

            if (maxQuantity < value) {
                maxQuantity = value;
            }
        }

        int[] answer = new int[5];

        for (int i = 0; i < answer.length; i++) {
            char alphabet = 0;

            if (i == 0) {
                alphabet = 'a';
            } else if (i == 1) {
                alphabet = 'b';
            } else if (i == 2) {
                alphabet = 'c';
            } else if (i == 3) {
                alphabet = 'd';
            } else {
                alphabet = 'e';
            }

            answer[i] = maxQuantity - alphabetMap.getOrDefault(alphabet, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        AlphabetRate T = new AlphabetRate();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
