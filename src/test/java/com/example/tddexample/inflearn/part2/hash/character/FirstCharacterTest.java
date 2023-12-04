package com.example.tddexample.inflearn.part2.hash.character;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstCharacterTest {

    @DisplayName("문자가 한 번만 사용된 게 없으면 '-1'을 반환한다.")
    @Test
    void nonExistentSingleAlphabet() {
        String s = "aa";

        FirstCharacter firstCharacter = new FirstCharacter();
        int result = firstCharacter.solution(s);

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("문자가 한 번만 사용된 게 있다면 해당 INDEX를 반환한다.")
    @Test
    void existentSingleAlphabet() {
        String s = "aab";

        FirstCharacter firstCharacter = new FirstCharacter();
        int result = firstCharacter.solution(s);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("문자가 한 번만 사용된 게 2개 이상 이려면 있다면 가장 먼저 나온 문자의 INDEX를 반환한다.")
    @Test
    void duplicateSingleAlphabet() {
        String s = "acab";

        FirstCharacter firstCharacter = new FirstCharacter();
        int result = firstCharacter.solution(s);

        assertThat(result).isEqualTo(2);
    }


    @Test
    void testCase1() {
        String s = "statitsics";

        FirstCharacter firstCharacter = new FirstCharacter();
        int result = firstCharacter.solution(s);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void testCase2() {
        String s = "abcdeabcdfg";

        FirstCharacter firstCharacter = new FirstCharacter();
        int result = firstCharacter.solution(s);

        assertThat(result).isEqualTo(5);
    }
}
