package com.example.tddexample.inflearn.part2.sort.selectcard;

import java.util.Arrays;

public class CardGame {
    public int solution(int[] nums, int k) {
        Arrays.sort(nums);
        int[] differenceArr = new int[nums.length / 2];
        int sum = 0;
        int idx = 0;
        for (int i = nums.length - 1; i > 0; i -= 2) {
            differenceArr[idx++] = nums[i] - nums[i - 1];
            sum += nums[i - 1];
        }

        Arrays.sort(differenceArr);
        int priority = 0;
        for (int i = differenceArr.length - 1; i > 0; i--) {
            if (priority >= k) {
                break;
            }
            sum += differenceArr[i];
            priority++;
        }
        return sum;
    }

    public static void main(String[] args) {
        CardGame T = new CardGame();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
