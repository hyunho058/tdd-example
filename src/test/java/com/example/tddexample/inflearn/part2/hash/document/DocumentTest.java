package com.example.tddexample.inflearn.part2.hash.document;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DocumentTest {

    @DisplayName("times 시작 시간과 종료시간에 속해 있으면 이름을 반환한다.")
    @Test
    void test() {
        String[] reports = {"john 09:00"};
        String times = "08:33 09:45";

        Document document = new Document();
        List<String> suspects = document.solution(reports, times);

        assertThat(suspects).containsExactly("john");
    }
    @DisplayName("기준 시간이 비교할 시간 보다 전이면 true")
    @Test
    void isBefore() {
        Document.Time before = new Document.Time(10, 30);
        Document.Time after = new Document.Time(11, 30);

        boolean result = before.isBefore(after);
        assertThat(result).isTrue();
    }

    @DisplayName("기준 시간과 비교할 시간이 같고 기준 시간 분이 전이면 true")
    @Test
    void beforeMinute() {
        Document.Time before = new Document.Time(10, 30);
        Document.Time after = new Document.Time(10, 31);

        boolean result = before.isBefore(after);
        assertThat(result).isTrue();
    }

    @DisplayName("기준 시간이 비교할 시간 보다 이후 이면 true")
    @Test
    void isAfter() {
        Document.Time before = new Document.Time(10, 30);
        Document.Time after = new Document.Time(11, 30);

        boolean result = after.isAfter(before);
        assertThat(result).isTrue();
    }

    @DisplayName("기준 시간과 비교할 시간이 같고 기준 시간 분이 후이면 true")
    @Test
    void afterMinute() {
        Document.Time before = new Document.Time(10, 30);
        Document.Time after = new Document.Time(10, 31);

        boolean result = after.isAfter(before);
        assertThat(result).isTrue();
    }
    @DisplayName("들어간 시간이 시작 시간과 종료 시간 사이에 포함되어 있으면 true")
    @Test
    void containTime() {
        Document.Time start = new Document.Time(10, 0);
        Document.Time end = new Document.Time(11, 0);
        Document.Lost lost = new Document.Lost(start, end);
        Document.Time enter = new Document.Time(10, 0);

        boolean result = lost.contain(enter);
        assertThat(result).isTrue();
    }

    @DisplayName("들어간 시간이 시작 시간과 종료 시간 사이이면 true")
    @Test
    void NotContainTime() {
        Document.Time start = new Document.Time(10, 0);
        Document.Time end = new Document.Time(11, 0);
        Document.Lost lost = new Document.Lost(start, end);
        Document.Time enter = new Document.Time(9, 59);

        boolean result = lost.contain(enter);
        assertThat(result).isFalse();
    }

    @Test
    void testCase1() {
        String[] reports = {"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"};
        String times = "08:33 09:45";

        Document document = new Document();
        List<String> suspects = document.solution(reports, times);

        assertThat(suspects).containsExactly("luis", "daniel");
    }
    @Test
    void testCase2() {
        String[] reports = {"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"};
        String times = "15:01 19:59";

        Document document = new Document();
        List<String> suspects = document.solution(reports, times);

        assertThat(suspects).containsExactly("john", "bill", "bob");
    }
}
