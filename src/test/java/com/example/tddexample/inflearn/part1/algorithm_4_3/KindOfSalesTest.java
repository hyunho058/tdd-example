package com.example.tddexample.inflearn.part1.algorithm_4_3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class KindOfSalesTest {


    @Test
    void test1() {
        KindOfSales kindOfSales = new KindOfSales();
        List<Integer> results = kindOfSales.sales(
            7,
            4,
            new int[]{20, 12, 20, 10, 23, 17, 10}
        );

        assertThat(results).containsExactly(3, 4, 4, 3);
    }

    @Test
    void test2() {
        KindOfSales kindOfSales = new KindOfSales();
        List<Integer> results = kindOfSales.sales(
            20,
            10,
            new int[]{
                365, 50, 50, 150, 60,
                150, 154, 215, 150, 315,
                293, 226, 408, 11, 344,
                199, 313, 82, 394, 304
            }
        );

        assertThat(results).containsExactly(7 ,7 ,8 ,8 ,9 ,9 ,10 ,10 ,10 ,10, 10);
    }
}
