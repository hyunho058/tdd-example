package com.example.tddexample.inflearn.part1.algorithm_6_6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StudentTest {

    @Test
    void test1() {
        Student student = new Student();
        List<Integer> result = student.find(new int[]{120, 125, 152, 130, 135, 135, 143, 127, 160});

        assertThat(result).containsExactly(3, 8);
    }

    @Test
    void test2() {
        Student student = new Student();
        List<Integer> result = student.find(new int[]{125, 161, 138, 140, 145, 147, 154, 154, 130, 173});

        assertThat(result).containsExactly(2,9);
    }
//122 123 125 125 128 130 133 137 138 138 140 141 142 143 145
//147 149 149 154 154 155 157 161 167 167 167 161 170 173 173
//125 161 138 140 145
//147 154 154 130 173
}

//125 130 138 140 145
//147 154 154 161 173
/**
 * 125
 */
//120 123 125
//130 152
//
//120 125 152 130 135
//135 143 127 160