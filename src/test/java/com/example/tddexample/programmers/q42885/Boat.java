package com.example.tddexample.programmers.q42885;

import java.util.Arrays;

public class Boat {

    private final int[] people;
    private final int limit;

    public Boat(int[] people, int limit) {
        this.people = people;
        this.limit = limit;
    }

    public int windowSlid() {
        Arrays.sort(people);

        int leftIdx = 0;
        int rightIdx = people.length - 1;
        int boatCount = 0;

        while (leftIdx <= rightIdx) {
            if (people[leftIdx] + people[rightIdx] <= limit) {
                leftIdx++;
            }

            rightIdx--;
            boatCount++;
        }

        return boatCount;
    }
}
