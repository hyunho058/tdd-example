package com.example.tddexample.inflearn.algorithm_5_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveCharacterTest {

    @Test
    void test11() {
        RemoveCharacter removeCharacter = new RemoveCharacter();
        String result = removeCharacter.removal("(A(BC)D)EF(G(H)(IJ)K)LM(N)");

        assertThat(result).isEqualTo("EFLM");
    }

    @Test
    void test2() {
        RemoveCharacter removeCharacter = new RemoveCharacter();
        String result = removeCharacter.removal("AB(CD)Q(E(F(G(H(I)J)K)L)N)Q");

        assertThat(result).isEqualTo("ABQQ");
    }
}
