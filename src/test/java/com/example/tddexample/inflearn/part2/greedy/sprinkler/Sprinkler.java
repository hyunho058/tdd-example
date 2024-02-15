package com.example.tddexample.inflearn.part2.greedy.sprinkler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprinkler {
    public int solution(int n, int[] nums) {
        List<Scope> scopes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            scopes.add(Scope.from(nums[i], i, nums.length - 1));
        }
        Collections.sort(scopes);


        int result = 0;
        Scope selectedScope = scopes.get(0);
        for (int i = 1; i < scopes.size(); i++) {
            Scope current = scopes.get(i);
            System.out.println("--------------------start------------------");
            System.out.println("selected : " + selectedScope.toString() + " \n  cueent : " + current.toString());

            if (selectedScope.nonIntersecting(current.getStart())) {
                return -1;
            }

            if (selectedScope.wide(current)) {
                selectedScope = current;
                continue;
            }

            if (selectedScope.small(current)) {
                continue;
            }

            if (selectedScope.getStart() < current.getStart() && selectedScope.getEnd() < current.getEnd()) {
                System.out.println("\nhit : " + selectedScope.toString()+"\n");
                selectedScope = current;
                result++;
            }

        }
        return result;
    }

    protected static class Scope implements Comparable<Scope> {
        private final int start;
        private final int end;

        public Scope(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Scope from(int scope, int position, int length) {
            int startScope = Math.max(0, position - scope);
            int endScope = Math.min((position + scope), length);

            return new Scope(startScope, endScope);
        }

        @Override
        public int compareTo(Scope o) {
            return start - o.start;
        }

        public boolean nonIntersecting(int nextStart) {
            return this.end < nextStart;
        }

        public boolean wide(Scope nextScope) {
            return this.start == nextScope.getStart()
                    && this.end < nextScope.getEnd();
        }

        public boolean small(Scope nextScope) {
            return this.start <= nextScope.getStart()
                    && this.end >= nextScope.getEnd();
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Scope{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
