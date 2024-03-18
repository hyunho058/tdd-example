package com.example.tddexample.inflearn.part2.sort.task;

public class MultiTasking {
    public int solution(int[] tasks, long k) {
        int n = tasks.length;
        long totalTasksTime = 0;

        // 전체 작업 시간을 계산합니다.
        for (int taskTime : tasks) {
            totalTasksTime += taskTime;
        }

        // k가 전체 작업 시간보다 크면 모든 작업이 완료된 것입니다.
        if (k >= totalTasksTime) {
            return -1;
        }

        // k를 전체 작업 시간으로 나눈 나머지가 실제 처리해야 할 시간입니다.
        k = k % totalTasksTime;

        // k초 후에 처리해야 할 작업을 찾습니다.
        for (int i = 0; i < n; i++) {
            // k에서 현재 작업 시간을 뺍니다.
            k -= tasks[i];

            // 만약 k가 0 이하가 되면, 이 작업이 정전 후에 처리해야 할 작업입니다.
            if (k < 0) {
                return i + 1; // 작업 번호는 1부터 시작하므로 1을 더합니다.
            }
        }

        // 모든 작업을 처리했으므로 -1을 반환합니다.
        return -1;
    }

    public static void main(String[] args) {
        MultiTasking T = new MultiTasking();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
