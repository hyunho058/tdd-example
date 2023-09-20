package com.example.tddexample.inflearn.algorithm_6_2;

public class Numbers {

    public int[] sort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length - i; j++) {
                int leftNumber = numbers[j];
                int rightNumber = numbers[j + 1];

                if (leftNumber > rightNumber) {
                    numbers[j + 1] = leftNumber;
                    numbers[j] = rightNumber;
                }
            }
        }

        return numbers;
    }
}
