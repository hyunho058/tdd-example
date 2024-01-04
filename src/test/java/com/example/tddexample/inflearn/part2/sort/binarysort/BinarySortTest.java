package com.example.tddexample.inflearn.part2.sort.binarysort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySortTest {

    @DisplayName("6과 7의 이진수를 비교하여 1의 개수가 적은 순서로 오름차순 정렬하면 {6, 7} 이 반환된다.")
    @Test
    void binaryOrderBy() {
        BinarySort binarySort = new BinarySort();
        int[] sorted = binarySort.sort(new int[]{6, 7});

        assertThat(sorted).containsExactly(6, 7);
    }

    @DisplayName("6과 9의 이진수를 비교 하여 1의 개수가 같다면 10진수로 오름차순 정렬한다.")
    @Test
    void sameOneCount() {
        BinarySort binarySort = new BinarySort();
        int[] sorted = binarySort.sort(new int[]{9, 6});

        assertThat(sorted).containsExactly(6, 9);
    }

    @Test
    void testCase1() {
        BinarySort binarySort = new BinarySort();
        int[] sorted = binarySort.sort(new int[]{5, 6, 7, 8, 9});

        assertThat(sorted).containsExactly(8, 5, 6, 9, 7);
    }

    @Test
    void testCase2() {
        BinarySort binarySort = new BinarySort();
        int[] sorted = binarySort.sort(new int[]{12, 5, 7, 23, 45, 21, 17});

        assertThat(sorted).containsExactly(5, 12, 17, 7, 21, 23, 45);
    }


}
