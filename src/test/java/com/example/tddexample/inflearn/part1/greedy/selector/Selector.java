package com.example.tddexample.inflearn.part1.greedy.selector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Selector {

    private final int n;
    private final int[][] person;
    private final List<Person> personList;

    public Selector(int n, int[][] person) {
        this.n = n;
        this.person = person;
        this.personList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] person = new int[n][2];

        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            person[i][0] = h;
            person[i][1] = w;
        }

        Selector main = new Selector(n, person);
        int result = main.greedy();

        System.out.println(result);
    }

    public int greedy() {
        for (int[] i : person) {
            personList.add(new Person(i[0], i[1]));
        }
        Collections.sort(personList);

        int maxWeight = Integer.MIN_VALUE;
        int answer = 0;

        for (Person p : personList) {
            if (p.weight > maxWeight){
                maxWeight = p.weight;
                answer++;
            }
        }



        return answer;
    }

    protected static class Person implements Comparable<Person> {
        private final int height;
        private final int weight;


        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
}
