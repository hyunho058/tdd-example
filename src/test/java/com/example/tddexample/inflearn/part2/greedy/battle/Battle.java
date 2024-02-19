package com.example.tddexample.inflearn.part2.greedy.battle;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Battle {
    public int[] solution(String[] students) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            String[] info = students[i].split(" ");
            studentList.add(new Student(i, info));
        }
        Collections.sort(studentList);

        Map<String, Integer> teamScores = new HashMap<>();
        int[] results = new int[studentList.size()];

        int total = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);


            results[student.getNumber()] = getScore(total, i, studentList, student) - teamScores.getOrDefault(student.getTeam(), 0);
            teamScores.put(student.getTeam(), teamScores.getOrDefault(student.getTeam(), 0) + student.getDamage());
            total += student.getDamage();
        }

        return results;
    }

    private int getScore(int total, int idx, List<Student> studentList, Student student) {
        int score = total;
        for (int j = idx - 1; j >= 0; j--) {
            Student beforeStudent = studentList.get(j);
            if (student.getDamage() > beforeStudent.getDamage()) {
                break;
            }

            if (student.getTeam().equals(beforeStudent.getTeam())) {
                continue;
            }

            score -= beforeStudent.getDamage();
        }

        return score;
    }

    protected static class Student implements Comparable<Student> {
        private final int number;
        private final String team;
        private final int damage;

        public Student(int number, String[] information) {
            this(number, information[0], Integer.parseInt(information[1]));
        }

        public Student(int number, String team, int damage) {
            this.number = number;
            this.team = team;
            this.damage = damage;
        }

        public int getNumber() {
            return number;
        }

        public String getTeam() {
            return team;
        }

        public int getDamage() {
            return damage;
        }

        @Override
        public int compareTo(Student o) {
            return this.damage - o.getDamage();
        }
    }
}
