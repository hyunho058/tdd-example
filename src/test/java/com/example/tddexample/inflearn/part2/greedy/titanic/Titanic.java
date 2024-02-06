package com.example.tddexample.inflearn.part2.greedy.titanic;

import java.util.Arrays;

public class Titanic {

    public int boatCount(int[] nums, int m) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        int answer = 0;
        int rIdx = nums.length - 1;
        for (int lIdx = 0; lIdx < nums.length; lIdx++) {
            if (last(lIdx, rIdx)) {
                answer++;
                break;
            }

            if (lIdx > rIdx) {
                break;
            }

            if (passTheWeightLimit(m, nums[lIdx] + nums[rIdx])) {
                rIdx--;
            }

            answer++;
        }

        return answer;
    }

    private boolean passTheWeightLimit(int limit, int sum) {
        return sum <= limit;
    }

    private boolean last(int leftIdx, int rightIdx) {
        return leftIdx == rightIdx;
    }
}
