package com.example.tddexample.programmers.q42885;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

    @DisplayName("허용 무게가 남아있어도 구명보트는 최대 두명까지 탈 수 있다.")
    @Test
    void maximumOccupancy() {
        int[] people = {40, 40, 40};
        int limit = 120;

        Boat boat = new Boat(people, limit);
        int result = boat.windowSlid();

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("두사람의 무게 합이 허용무게를 넘으면 보느튼 한사람씩 타야한다.")
    @Test
    void overweight() {
        int[] people = {50, 40};
        int limit = 60;

        Boat boat = new Boat(people, limit);
        int result = boat.windowSlid();

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("총 세개의 보트가 필요하다.")
    @Test
    void testCase1() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        Boat boat = new Boat(people, limit);
        int result = boat.windowSlid();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("총 세개의 보트가 필요하다.")
    @Test
    void testCase2() {
        int[] people = {70,80,50};
        int limit = 100;

        Boat boat = new Boat(people, limit);
        int result = boat.windowSlid();

        assertThat(result).isEqualTo(3);
    }
}