package com.example.tddexample.inflearn.part1.algorithm_4_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAnagramTest {
    @DisplayName("문자열이 순서와 상관 없이 구성된 알파뱃이 같으면 같다.")
    @Test
    void test1(){
        FindAnagram anagram = new FindAnagram();
        int count = anagram.count("bca", "abc");

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("알파뱃 대소문자는 다르게 판단한다.")
    @Test
    void test2(){
        FindAnagram anagram = new FindAnagram();
        int count = anagram.count("bcA", "abc");

        assertThat(count).isEqualTo(0);
    }

    @DisplayName("abc가 포함된 연속된 문자열은 3개 이다.")
    @Test
    void test3(){
        FindAnagram anagram = new FindAnagram();
        int count = anagram.count("bacaAacba", "abc");

        assertThat(count).isEqualTo(3);
    }

    @Test
    void test4(){
        FindAnagram anagram = new FindAnagram();
        int count = anagram.count(
            "WetabtqtqEFqGHIJKLtabeWPQRSTUVWetabdgXYabteWcdefghijklmnopqrabtWestuwxyz",
            "Wetab"
        );

        assertThat(count).isEqualTo(5);
    }
}
