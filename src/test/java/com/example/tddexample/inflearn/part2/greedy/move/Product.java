package com.example.tddexample.inflearn.part2.greedy.move;

import java.util.Arrays;

public class Product {
    public int moveCount(int[] nums){
        Arrays.sort(nums);

        int maxWeight = 5;
        int answer = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= maxWeight) {
                left++;
                right--;
                answer++;
                continue;
            }
            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Product T = new Product();
        System.out.println(T.moveCount(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.moveCount(new int[]{2, 3, 4, 5}));
        System.out.println(T.moveCount(new int[]{3, 3, 3, 3, 3}));
    }
}
