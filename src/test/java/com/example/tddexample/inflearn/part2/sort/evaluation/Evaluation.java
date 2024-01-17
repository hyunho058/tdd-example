package com.example.tddexample.inflearn.part2.sort.evaluation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Evaluation {
    public int solution(int[] score, int k){
        Arrays.sort(score);
        Queue<Integer> scoreQueue = new LinkedList<>();
        for (int number : score) {
            if (scoreQueue.isEmpty()) {
                scoreQueue.offer(number);
                continue;
            }

            scoreQueue.offer(number);
            if (10 < number - scoreQueue.peek()) {
                scoreQueue.poll();
                continue;
            }

            if (scoreQueue.size() == k) {
                break;
            }
        }
//80 85 91 92 95 97 99
        return average(scoreQueue);
    }

    private int average(Queue<Integer> queue) {
        int sum = queue.stream()
                .mapToInt(i -> i)
                .sum();

        return sum/queue.size();
    }

    public static void main(String[] args){
        Evaluation T = new Evaluation();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
