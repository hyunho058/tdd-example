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

            //e1이 scopes마지막 자리와 같다면 이후 loop는 돌지 않는다.
            if (selectedScope.isLastPosition(scopes.size() - 1)) {
                result++;
                break;
            }

            //e1보다 s2가 크다. => return -1
            if (selectedScope.nonIntersecting(current.getStart())) {
                return -1;
            }

            //s1과 s2가 같고 e1보다 e2가 크다 => current 변경
            if (selectedScope.wide(current)) {
                selectedScope = current;
                continue;
            }

            //s1보다 s2가 크고 e1과 e2가 크다 => 현재 current 를 사용(result + 1), current를 변경
            if (selectedScope.getStart() < current.getStart() && selectedScope.getEnd() < current.getEnd()) {
                selectedScope = current;
                result++;
                continue;
            }

            //s1보다 s2가 크고 e1과 e2가 같다 => 현재 current 를 사용(result + 1),
            if (selectedScope.isSmall(current)) {
                continue;
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

        public boolean isLastPosition(int size) {
            return this.end == size;
        }


        public boolean nonIntersecting(int nextStart) {
            return this.end < nextStart;
        }

        public boolean wide(Scope nextScope) {
            return this.start == nextScope.getStart()
                    && this.end < nextScope.getEnd();
        }

        public boolean isSmall(Scope nextScope) {
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
