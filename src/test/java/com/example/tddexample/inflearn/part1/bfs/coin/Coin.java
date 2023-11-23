package com.example.tddexample.inflearn.part1.bfs.coin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Coin {
    private final int n;
    private final int[] m;
    private final int changeMoney;

    public Coin(int n, int[] m, int changeMoney) {
        this.n = n;
        this.m = m;
        this.changeMoney = changeMoney;
    }

    public int bfs(int start) {
        int level = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int sumCoin = queue.poll();

                for (int coin : m) {
                    int value = sumCoin + coin;
                    if (value == changeMoney) {
                        return level + 1;
                    }
                    queue.offer(value);
                }
            }
            level++;
        }

        return level;
    }

    ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        Coin main = new Coin(n, arr, m);
        int result = main.bfs(0);
        System.out.println(result);
    }
}
