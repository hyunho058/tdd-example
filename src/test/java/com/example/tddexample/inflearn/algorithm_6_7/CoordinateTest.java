package com.example.tddexample.inflearn.algorithm_6_7;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class CoordinateTest {
//    @Test
//    void test() {
//        Coordinate coordinate = new Coordinate();
//        LinkedList<Coordinate.Position> sort = coordinate.sort(
//            new int[][]{
//                {2, 7},
//                {1, 3},
//                {2, 7},
//                {1, 3},
//                {1, 2},
//                {2, 5},
//                {3, 6}
//            });
//
//        for (Coordinate.Position position : sort) {
//            System.out.println(position.toString());
//        }
//    }

    @Test
    void test() {
        Coordinate coordinate = new Coordinate();
        int[][] sort = coordinate.sort(
            new int[][]{
                {2, 7},
                {1, 3},
                {2, 7},
                {1, 3},
                {1, 2},
                {2, 5},
                {3, 6}
            });

        for (int[] position : sort) {
            System.out.println(position[0] + " " + position[1]);
        }
    }
}
