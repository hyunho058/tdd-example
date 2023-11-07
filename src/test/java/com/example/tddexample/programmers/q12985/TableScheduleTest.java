package com.example.tddexample.programmers.q12985;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableScheduleTest {
    @DisplayName("")
    @Test
    void test() {
        int n = 8;
        int a = 4;
        int b = 7;

        TableSchedule tableSchedule = new TableSchedule(n ,a, b);
        int round = tableSchedule.round();

        assertThat(round).isEqualTo(3);
    }
}
