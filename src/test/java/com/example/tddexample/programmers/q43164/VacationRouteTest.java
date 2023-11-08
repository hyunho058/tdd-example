package com.example.tddexample.programmers.q43164;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VacationRouteTest {
    @DisplayName("")
    @Test
    void test() {
        String[][] tickets = {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
        };

        VacationRoute vacation = new VacationRoute(tickets);
        String[] result = vacation.route();

        assertThat(result).containsExactly("ICN", "JFK", "HND", "IAD");
    }

    @DisplayName("")
    @Test
    void test1() {
        String[][] tickets = {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL","SFO"}
        };

        VacationRoute vacation = new VacationRoute(tickets);
        String[] result = vacation.route();

        assertThat(result).containsExactly("ICN", "ATL", "ICN", "SFO", "ATL", "SFO");
    }

    @DisplayName("")
    @Test
    void test2() {
        String[][] tickets = {
            {"ICN", "BOO"},
            {"ICN", "COO"},
            {"COO", "DOO"},
            {"DOO", "COO"},
            {"BOO", "DOO"},
            {"DOO", "BOO"},
            {"BOO", "ICN"},
            {"COO", "BOO"}
        };

        VacationRoute vacation = new VacationRoute(tickets);
        String[] result = vacation.route();

        assertThat(result).containsExactly("ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO");
    }
}