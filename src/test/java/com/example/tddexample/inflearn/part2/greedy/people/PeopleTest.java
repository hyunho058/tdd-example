package com.example.tddexample.inflearn.part2.greedy.people;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {

    @Test
    void testCase1() {
        int n = 5;
        int[][] trains = {{1, 4, 2}, {2, 5, 1}};
        int[][] bookings = {{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}};

        People people = new People();
        int result = people.maximum(n, trains, bookings);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void testCase2() {
        int n = 5;
        int[][] trains = {{2, 3, 1}, {1, 5, 1}};
        int[][] bookings = {{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}};

        People people = new People();
        int result = people.maximum(n, trains, bookings);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void testCase3() {
        int n = 8;
        int[][] trains = {{1, 8, 3}, {3, 8, 1}};
        int[][] bookings = {{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}};

        People people = new People();
        int result = people.maximum(n, trains, bookings);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void testCase4() {
        int n = 9;
        int[][] trains = {{1, 8, 3}, {3, 9, 2}, {1, 5, 3}};
        int[][] bookings = {{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}};

        People people = new People();
        int result = people.maximum(n, trains, bookings);

        assertThat(result).isEqualTo(8);
    }

    @DisplayName("오름차순 정렬")
    @Test
    void orderBy() {
        int[] numbers = {2, 4, 1, 5, 3};
        Arrays.sort(numbers);

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5);

        List<Integer> numberList = Arrays.asList(2, 4, 1, 5, 3);
        Collections.sort(numberList);

        assertThat(numberList).containsExactly(1, 2, 3, 4, 5);
    }
}
