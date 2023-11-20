package com.example.tddexample.programmers.q43105;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @DisplayName("")
    @Test
    void test() {
        int[][] triangleArr = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };

        Triangle triangle = new Triangle(triangleArr);
        int result = triangle.maxSum();

        Assertions.assertThat(result).isEqualTo(30);
    }
}