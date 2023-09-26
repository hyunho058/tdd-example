package com.example.tddexample.inflearn.algortihm_6_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTest {

    @DisplayName("")
    @Test
    void testCase2() {
        Memory memory = new Memory();
        List<Integer> result = memory.leastRecentlyUsed(5, new int[]{1, 2, 3, 2, 6, 2, 3, 5, 7});

        assertThat(result).containsExactly(7, 5, 3, 2, 6);
    }
}
