package com.example.tddexample.inflearn.part2.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySortTest {
    @DisplayName("숫자 1과 3의 이진수에 1이 포함된 수를 비교하여 오름차순 정렬한다.")
    @Test
    void ascendingSort() {
        int[] bums = {3, 1};

        BinarySort binarySort = new BinarySort();
        int[] result = binarySort.solution(bums);

        assertThat(result).containsExactly(1, 3);
    }

    @DisplayName("숫자 1과 2의 이진수에 1이 포함된 수는 같으므로 10진수가 작은 순으로 오름차순 정렬한다.")
    @Test
    void sameOneCount() {
        int[] bums = {2, 1};

        BinarySort binarySort = new BinarySort();
        int[] result = binarySort.solution(bums);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    void testCase1() {
        int[] bums = {5, 6, 7, 8, 9};

        BinarySort binarySort = new BinarySort();
        int[] result = binarySort.solution(bums);

        assertThat(result).containsExactly(8, 5, 6, 9, 7);
    }

    @Test
    void testCase2() {
        int[] bums = {12, 5, 7, 23, 45, 21, 17};

        BinarySort binarySort = new BinarySort();
        int[] result = binarySort.solution(bums);

        assertThat(result).containsExactly(5, 12, 17, 7, 21, 23, 45);
    }
}
