package com.example.tddexample.inflearn.greedy.room;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class AssignmentTest {
    @DisplayName("회의실 배정")
    @Test
    void test() {
        int n = 5;
        int[][] conference = {
            {1, 4},
            {2, 3},
            {3, 5},
            {4, 6},
            {5, 7}
        };

        Assignment assignment = new Assignment(n, conference);
        int result = assignment.greedy();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("회의실 종료시간 오름차순 정렬")
    @Test
    void orderByAscending() {
        List<Assignment.Conference> conferences = new ArrayList<>();

        conferences.add(new Assignment.Conference(1, 4));
        conferences.add(new Assignment.Conference(2, 3));
        conferences.add(new Assignment.Conference(3, 5));
        conferences.add(new Assignment.Conference(4, 6));
        conferences.add(new Assignment.Conference(5, 7));

        Collections.sort(conferences);

        assertThat(conferences).extracting("startTime", "endTime")
            .containsExactlyInAnyOrder(
                tuple(2, 3),
                tuple(1, 4),
                tuple(3, 5),
                tuple(4, 6),
                tuple(5, 7)
            );
    }

    @DisplayName("종료시간이 같다면 시작 시간으로 오름차순 정렬을 한다.")
    @Test
    void orderByAscendingInTheSameEndTime() {
        List<Assignment.Conference> conferences = new ArrayList<>();

        conferences.add(new Assignment.Conference(3, 3));
        conferences.add(new Assignment.Conference(1, 3));
        conferences.add(new Assignment.Conference(2, 3));
        conferences.add(new Assignment.Conference(4, 6));
        conferences.add(new Assignment.Conference(5, 7));

        Collections.sort(conferences);

        assertThat(conferences).containsExactly(conferences.get(0));

        assertThat(conferences).extracting("startTime", "endTime")
            .containsExactlyInAnyOrder(
                tuple(1, 3),
                tuple(2, 3),
                tuple(3, 3),
                tuple(4, 6),
                tuple(5, 7)
            );
    }
}