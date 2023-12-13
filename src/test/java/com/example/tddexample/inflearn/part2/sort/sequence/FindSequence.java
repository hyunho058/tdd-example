package com.example.tddexample.inflearn.part2.sort.sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSequence {
    public int[] solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        Arrays.sort(nums);

        int[] answer = new int[nums.length / 2];
        int insertIdx = 0;
        for (int number : nums) {
            if (insertIdx == answer.length) {
                break;
            }

            int doubleNumber = number * 2;

            Integer value = map.get(number);
            if (value == 0) {
                continue;
            }
            map.put(number, value - 1);
            answer[insertIdx++] = number;

            Integer doubleValue = map.get(doubleNumber);
            if (doubleValue == null) {
                continue;
            }
            map.put(doubleNumber, doubleValue - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        FindSequence T = new FindSequence();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
