package com.example.tddexample.inflearn.part2.bytonic;

import java.util.ArrayList;
import java.util.List;

public class Bytonic {
    public int solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            int leftNumber = nums[i - 1];
            int rightNumber = nums[i + 1];
            int number = nums[i];

            if (leftNumber < number && number > rightNumber) {
                peaks.add(i);
            }
        }

        for (int i = 0; i < peaks.size(); i++) {

            int leftIndex = peaks.get(i);
            int count = 1;
            while (leftIndex > 0 && nums[leftIndex - 1] < nums[leftIndex]) {
                count++;
                leftIndex--;
            }

            int rightIndex = peaks.get(i);
            while (rightIndex < nums.length-1 && nums[rightIndex + 1] < nums[rightIndex]) {
                count++;
                rightIndex++;
            }

            if (max < count) {
                max = count;
            }
        }


        return max;
    }


    public static void main(String[] args) {
        Bytonic T = new Bytonic();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
