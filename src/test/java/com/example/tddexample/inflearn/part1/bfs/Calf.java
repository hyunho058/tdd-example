package com.example.tddexample.inflearn.part1.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();

        Calf main = new Calf();
        int result = main.bfs(s, e);

        System.out.println(result);
    }
    private final int[] dis = {1, -1, 5};

    public int bfs(int start, int destination) {
        int[] visited = new int[10001];
        visited[start] = 1;
        int level = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int number = queue.poll();

                for (int di : dis) {
                    int calcResult = number + di;

                    if (calcResult == destination) {
                        return level + 1;
                    }

                    if (calcResult >=1 && calcResult <= 10000 && visited[calcResult] == 0) {
                        queue.offer(calcResult);
                        visited[calcResult] = 1;
                    }

                }
            }
            level++;
        }
        return 0;
    }
}
