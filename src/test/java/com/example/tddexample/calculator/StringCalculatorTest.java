package com.example.tddexample.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    /**
     * 쉼표 콜론을 구분자로 가지는 문자열을 전달하는경우 구분자를 기중으로 분리한 각 숫자의 합을 반환
     *  커스텀 구분자 //문자열\n  ex) //;\n1;2;3 = 6
     *  문자열 계산기에 음수를 전달하면 RuntimeException으로 처리
     */

    @DisplayName("1,2 는 3이다.")
    @Test
    void commaIsAddition() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.addition("1,2");

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("1:2 는 3이다.")
    @Test
    void colonIsAddition() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.addition("1:2");

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("콜론과 쉼표 이외 구분자를 사용 하려면 다음과 같이 작성 한다. //;\n1;2")
    @Test
    void customSeparator() {
        String text = "//;\n1;2";

        StringCalculator calculator = new StringCalculator();
        int result = calculator.addition(text);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("//;\n1;2:3 는 6이다.")
    @Test
    void compositeSeparator() {
        String text = "//;\n1;2:3";

        StringCalculator calculator = new StringCalculator();
        int result = calculator.addition(text);

        assertThat(result).isEqualTo(6);
    }
}
