package com.example.tddexample.programmers.q138476;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tangerine {
    private final int maxSize;
    private final int[] tangerineArr;

    public Tangerine(int maxSize, int[] tangerineArr) {
        this.maxSize = maxSize;
        this.tangerineArr = tangerineArr;
    }


    public int typeCount() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerineArr) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Stock> stockList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            stockList.add(new Stock(key, map.get(key)));
        }
        Collections.sort(stockList);

        int type = 0;
        int sumSize = 0;
        for (Stock stock : stockList) {
            int count = stock.getCount();

//            if (stock.loadable(maxSize - sumSize)) {
            if (maxSize - sumSize > 0) {
                sumSize += count;
                type++;
            }

            if (maxSize == sumSize) {
                break;
            }
        }

        return type;
    }

    protected static class Stock implements Comparable<Stock> {
        private final int size;
        private final int count;

        public Stock(int size, int count) {
            this.size = size;
            this.count = count;
        }

        public int getSize() {
            return size;
        }

        public int getCount() {
            return count;
        }

        public boolean loadable(int redundancy) {
            return this.count <= redundancy;
        }

        @Override
        public int compareTo(Stock o) {
            return o.getCount() - this.count;
        }
    }
}
