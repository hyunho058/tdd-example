package com.example.tddexample.inflearn.anagram;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @DisplayName("두 단어 구성이 일치할 경우 결과는 YES")
    @Test
    void anagramSameWord(){
        Anagram anagram = new Anagram();

        String result = anagram.anagram("AbaAeCe", "baeeACA");

        assertThat("YES").isEqualTo(result);
    }

    @DisplayName("두 단어 구성이 불일치할 경우 결과는 NO")
    @Test
    void anagramNotSameWord(){
        Anagram anagram = new Anagram();

        String result = anagram.anagram("abaCC", "Caaab");

        assertThat("NO").isEqualTo(result);
    }
}