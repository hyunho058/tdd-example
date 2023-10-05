package com.example.tddexample.inflearn.algortihm_6_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTest {

    @DisplayName("1 과 2를 사용 하였을때 가장 최근 사용된 데이터는 2이다.")
    @Test
    void testCase1() {
        Memory memory = new Memory();
        List<Integer> result = memory.leastRecentlyUsed(2, new int[]{1, 2});

        assertThat(result.get(0)).isEqualTo(2);
    }

    @DisplayName("같은 수가 두번 사용 될경우 두번째 HIT가 되어 cache에는 한개의 데이터만 남게 된다.")
    @Test
    void testCase2() {
        Memory memory = new Memory();
        List<Integer> result = memory.leastRecentlyUsed(3, new int[]{1, 1});

        assertThat(result).containsExactly(1);
        assertThat(result).hasSize(1);
    }

    @Test
    void testCase3() {
        Memory memory = new Memory();
        List<Integer> result = memory.leastRecentlyUsed(5, new int[]{1, 2, 3, 2, 6, 2, 3, 5, 7});

        assertThat(result).containsExactly(7, 5, 3, 2, 6);
    }
}
