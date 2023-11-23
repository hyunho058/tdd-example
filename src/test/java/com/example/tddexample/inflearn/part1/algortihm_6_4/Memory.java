package com.example.tddexample.inflearn.part1.algortihm_6_4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Memory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        Memory main = new Memory();
        List<Integer> result = main.leastRecentlyUsed(s, ints);

        for (int i  : result) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> leastRecentlyUsed(int cacheSize, int[] jobs) {
        LinkedList<Integer> cache = new LinkedList<>();
        for (int job : jobs) {
            if (cache.isEmpty()) {
                cache.add(job);
                continue;
            }

            for (int j = 0; j < cache.size(); j++) {
                if (job == cache.get(j)) {
                    cache.remove(j);
                    break;
                }
            }

            cache.add(0, job);

            if (cache.size() > cacheSize) {
                cache.remove(cache.size() - 1);
            }
        }

        return cache;
    }

    static class Cache {
        private final LinkedList<Integer> memory;

        public Cache() {
            this(new LinkedList<Integer>());
        }

        public Cache(LinkedList<Integer> memory) {
            this.memory = memory;
        }

        public boolean isEmpty() {
            return false;
        }

    }
}
