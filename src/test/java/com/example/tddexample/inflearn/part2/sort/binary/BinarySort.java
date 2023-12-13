package com.example.tddexample.inflearn.part2.sort.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySort {
    public int[] solution(int[] nums) {
        List<Number> numbers = new ArrayList<>();
        for (int number : nums) {
            numbers.add(Number.from(number));
        }
        Collections.sort(numbers);

        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.get(i).getValue();
        }

        return answer;
    }

    protected static class Number implements Comparable<Number> {
        private final int value;
        private final String binary;

        public Number(int value, String binary) {
            this.value = value;
            this.binary = binary;
        }

        public static Number from(int number) {
            String binaryString = Integer.toBinaryString(number);

            return new Number(number, binaryString);
        }

        private int count() {
            return this.binary.length() - this.binary.replace("1", "").length();
        }

        public int getValue() {
            return this.value;
        }

        @Override
        public int compareTo(Number o) {
            if (this.count() == o.count()) {
                return this.value - o.value;
            }

            return this.count() - o.count();
        }
    }

    public static void main(String[] args) {
        BinarySort T = new BinarySort();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
