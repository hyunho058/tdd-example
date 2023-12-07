package com.example.tddexample.inflearn.part2.hash.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MailTest {
    @DisplayName("들오온 시간과 나간 시간을 계산(out - in)해 60분을 넘기면 이메일을 전송한다.")
    @Test
    void exceedingTheUsageTime() {
        String[] reports = {
            "john 09:00 in",
            "john 10:10 out",
        };
        int time = 60;

        Mail mail = new Mail();
        String[] result = mail.solution(reports, time);

        assertThat(result).containsExactly("john");
    }

    @Test
    void testCase1() {
        String[] reports = {
            "john 09:30 in",
            "daniel 10:05 in",
            "john 10:15 out",
            "luis 11:57 in",
            "john 12:03 in",
            "john 12:20 out",
            "luis 12:35 out",
            "daniel 15:05 out"
        };
        int time = 60;

        Mail mail = new Mail();
        String[] result = mail.solution(reports, time);

        assertThat(result).containsExactly("daniel", "john");
    }

    @Test
    void testCase2() {
        String[] reports = {
            "bill 09:30 in",
            "daniel 10:00 in",
            "bill 11:15 out",
            "luis 11:57 in",
            "john 12:03 in",
            "john 12:20 out",
            "luis 14:35 out",
            "daniel 14:55 out"
        };
        int time = 120;

        Mail mail = new Mail();
        String[] result = mail.solution(reports, time);

        assertThat(result).containsExactly("daniel", "luis");
    }
}
