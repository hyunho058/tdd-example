package com.example.tddexample.programmers.q43163;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordTransferTest {

    @DisplayName("hit->hot->dot->dog->cog와 같이 4단계를 거쳐 변환할 수 있어 결과는 4이다.")
    @Test
    void test1() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordTransfer wordTransfer = new WordTransfer(target, words);
        int result = wordTransfer.count(begin);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("word 에 target인 'cog' 가 없어 변환이 불가능하여, 결괏값은 0이다. ")
    @Test
    void test2() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        WordTransfer wordTransfer = new WordTransfer(target, words);
        int result = wordTransfer.count(begin);

        assertThat(result).isEqualTo(0);

    }
}
