package com.example.tddexample.inflearn.algorithm_5_7;

import java.util.LinkedList;
import java.util.Queue;

public class ClassPlan {

    public String available(String compulsorySubject, String subject) {
        Queue<Character> compulsorySubjectQueue = new LinkedList<>();
        for (char c : compulsorySubject.toCharArray()) {
            compulsorySubjectQueue.offer(c);
        }

        for (int i = 0; i < subject.length(); i++) {
            if (compulsorySubjectQueue.isEmpty()) {
                break;
            }

            if (isSame(compulsorySubjectQueue.peek(), subject.charAt(i))) {
                compulsorySubjectQueue.poll();
            }
        }

        return compulsorySubjectQueue.isEmpty() ? "YES" : "NO";
    }

    private boolean isSame(char c1, char c2) {
        return c1 == c2;
    }
}
