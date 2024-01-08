package com.example.tddexample.inflearn.part2.sort.binarysort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySort {

    public int[] sort(int[] nums) {
        List<Number> numbers = new ArrayList<>();
        for (int decimal : nums) {
            Number binaryInfo = create(decimal);
            numbers.add(binaryInfo);
        }

        Collections.sort(numbers);

        return toArray(numbers);
    }

    private Number create(int decimal) {
        int number = decimal;
        int oneCount = 0;
        while (number > 0) {
            int remainder = number % 2;
            number = number / 2;
            if (remainder == 0) {
                continue;
            }
            oneCount++;
        }

        return new Number(decimal, oneCount);
    }

    private int[] toArray(List<Number> numbers) {
        int[] sorted = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            sorted[i] = numbers.get(i).decimal;
        }

        return sorted;
    }

    private record Number(int decimal,
                          int count) implements Comparable<Number> {
        @Override
        public int compareTo(Number o) {
            if (this.count == o.count) {
                return this.decimal - o.decimal;
            }
            return this.count - o.count;
        }
    }
}
