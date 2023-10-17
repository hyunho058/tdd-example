package com.example.tddexample.inflearn.dfs;

import com.sun.source.tree.BinaryTree;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RecursionTest {

    @DisplayName("재귀를 활욘한 피보나치 구하기")
    @Test
    void test() {
        int number = 45;
        Recursion recursion = new Recursion(number);
        int result = recursion.fibonacci(number);

        int[] fibonacciNumbers = recursion.getFibonacciNumbers();
        for (int i = 1; i < fibonacciNumbers.length; i++) {
            System.out.println(fibonacciNumbers[i]);
        }

        assertThat(result).isEqualTo(55);
    }

}
