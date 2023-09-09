package com.example.tddexample.inflearn.algorithm_4_3;

import java.util.*;

public class KindOfSales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        KindOfSales main = new KindOfSales();
        List<Integer> results = main.sales(n, k, arr);

        for (Integer result : results) {
            System.out.print(result + " ");
        }

    }

    public List<Integer> sales(int n, int k, int[] sales) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int leftIdx = 0;

        for (int rightIdx = 0; rightIdx < n; rightIdx++) {
            int key = sales[rightIdx];
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (rightIdx < k - 1) {
                continue;
            }


            if (rightIdx > k - 1) {
                int deleteKey = sales[leftIdx++];

                map.put(deleteKey, map.getOrDefault(deleteKey, 0) - 1);
                Integer integer = map.get(deleteKey);

                if (integer <= 0){
                    map.remove(deleteKey);
                }
            }

            results.add(map.size());
        }

        return results;
    }
}
