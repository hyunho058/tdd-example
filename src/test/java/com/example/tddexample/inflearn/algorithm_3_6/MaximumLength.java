package com.example.tddexample.inflearn.algorithm_3_6;

public class MaximumLength {

    public int transformation(int n, int[] binaryArr) {
        int leftIdx = 0;
        int maxLength = 0;
        int currentLength = 0;
        int convertibleCount = 0;

        for (int binary : binaryArr) {
            if (binary == 0) {
                convertibleCount++;
            }

            currentLength++;

            //0을 1로 변환할 수 있는 수 'n'을 초과하면 가장 처음 바꾼 0까지 찾으며 현재 길이 감소
            while (convertibleCount > n) {
                if (binaryArr[leftIdx++] == 0) {
                    convertibleCount--;
                }

                currentLength--;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

        }

        return maxLength;
    }
}
