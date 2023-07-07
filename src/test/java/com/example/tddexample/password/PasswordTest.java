package com.example.tddexample.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 길이가 8글자 이상
 * 0부터 9사이 숫자 포함
 * 대문자 포함
 * 세 규칙을 모두충족하면 암호는 강함 RESISTANT
 * 2개의 규칙을 충족하면 암호는 보통 NORMAL
 * 1개 이하의 규칙을 충족하면 암호는 약함 WEAKNESS
 */
public class PasswordTest {
    @Test
    void 세가지_조건을_만종한_경우_강함() {
        Password password = new Password("12345678Ab");
        PasswordStrength validationResult = password.validation();

        Assertions.assertEquals(PasswordStrength.RESISTANT, validationResult);
    }

    @Test
    void 암호_길이만_만족하지_않을_경우() {
        Password password = new Password("1234Ab");
        PasswordStrength validationResult = password.validation();

        Assertions.assertEquals(PasswordStrength.NORMAL, validationResult);
    }

    @Test
    void 암호_대문자_조건만_만족하지_않은_경우() {
        Password password = new Password("12345678");
        PasswordStrength validationResult = password.validation();

        Assertions.assertEquals(PasswordStrength.NORMAL, validationResult);
    }

    @Test
    void 암호_숫자_포함_조건만_만족하는_경우() {
        Password password = new Password("abcde4e");
        PasswordStrength validationResult = password.validation();

        Assertions.assertEquals(PasswordStrength.WEAK, validationResult);
    }

    @Test
    void 대문자_조건만_만족하는_경우() {
        Password password = new Password("acdAe");
        PasswordStrength validationResult = password.validation();

        Assertions.assertEquals(PasswordStrength.WEAK, validationResult);
    }
}
