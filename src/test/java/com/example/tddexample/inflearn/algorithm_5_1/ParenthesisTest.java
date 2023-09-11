package com.example.tddexample.inflearn.algorithm_5_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParenthesisTest {
    /**
     * (())() true
     * ((())) true
     * (()(()))(() false
     * (()(())) true
     * ())()( false
     * ())()( false
     */

    @DisplayName("괄호의 수가 홀수 이면 괄호 쌍을 만들 수 없다.")
    @Test
    void parenthesesAreOdd() {
        Parenthesis parenthesis =  new Parenthesis();
        String result = parenthesis.generative("(()");

        assertThat(result).isEqualTo("NO");
    }

    @DisplayName("괄호 열고 닫는게 쌍울 이루면 괄호 생성 가능")
    @Test
    void parenthesesGenerative() {
        Parenthesis parenthesis =  new Parenthesis();
        String result = parenthesis.generative("(())");

        assertThat(result).isEqualTo("YES");
    }

    @DisplayName("닫힌 괄호가 열린 괄호 보다 먼저 오면 괄호 쌍을 만들 수 없다.")
    @Test
    void testCase1() {
        Parenthesis parenthesis =  new Parenthesis();
        String result = parenthesis.generative("())()(");

        assertThat(result).isEqualTo("NO");
    }

    @DisplayName("열린 괄호가 닫힌 괄호 보다 수가 앖으면 괄호 쌍을 만들 수 없다.")
    @Test
    void testCase2() {
        Parenthesis parenthesis =  new Parenthesis();
        String result = parenthesis.generative("()()(()(");

        assertThat(result).isEqualTo("NO");
    }

    @DisplayName("닫힌 괄호가 열린 괄호 보다 수가 앖으면 괄호 쌍을 만들 수 없다.")
    @Test
    void testCase3() {
        Parenthesis parenthesis =  new Parenthesis();
        String result = parenthesis.generative("()())())");

        assertThat(result).isEqualTo("NO");
    }
}
