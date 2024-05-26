package com.example.tddexample.inflearn.part2.greedy.move;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductEntityTest {
    @Test
    void testCase1() {
        int[] weights = {2, 5, 3, 4, 2, 3};

        Product product = new Product();
        int minimumMoves = product.moveCount(weights);

        assertThat(minimumMoves).isEqualTo(4);
    }

    @Test
    void testCase2() {
        int[] weights = {2, 3, 4, 5};

        Product product = new Product();
        int minimumMoves = product.moveCount(weights);

        assertThat(minimumMoves).isEqualTo(3);
    }

    @Test
    void testCase3() {
        int[] weights = {3, 3, 3, 3, 3};

        Product product = new Product();
        int minimumMoves = product.moveCount(weights);

        assertThat(minimumMoves).isEqualTo(5);
    }
}