package com.example.tddexample.inflearn.part1.algorithm_5_6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Princess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Princess main = new Princess();
        int result = main.princeNumber(N, K);
        System.out.println(result);
    }

    //queue에 k번째로 Poll이 되는 값을 제거하고 이전 값은 다시 queue로 add
    public int princeNumber(int n, int k) {
        Queue<Integer> princesQueue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            princesQueue.add(i);
        }

        int kCount = 0;
        while (princesQueue.size() > 1) {
            kCount++;
            Integer prince = princesQueue.poll();
            if (kCount < k) {
                princesQueue.add(prince);
                continue;
            }

            if (kCount == k){
                kCount = 0;
            }
        }

        Integer prince = princesQueue.peek();
        if (prince == null) {
            return 0;
        }

        return princesQueue.peek();
    }
}
