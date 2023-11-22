package com.example.tddexample.inflearn.part2.ladder;

import com.example.tddexample.test.airport.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    public char[] solution(int n, int[][] ladder) {
        List<List<Line>> lineInfos = new ArrayList<>();

        //init data
        for (int i = 0; i < ladder.length; i++) {
            List<Line> lines = new ArrayList<>();
            for (int j = 0; j < ladder[i].length; j++) {
                lines.add(new Line(ladder[i][j]));
            }
            lineInfos.add(lines);
        }

        char[] answer = new char[n];
        char alphabet = 'A';
        for (int i = 1; i <= n; i++) {
            int position = i;

            for (List<Line> LineList : lineInfos) {
                for (Line line : LineList) {
                    if (line.getStart() == position) {
                        position = line.getEnd();
                        break;
                    }

                    if (line.getEnd() == position) {
                        position = line.getStart();
                        break;
                    }
                }
            }

            answer[position - 1] = alphabet;
            alphabet++;
        }

        return answer;
    }


    private static class Line {
        private final int start;
        private final int end;

        public Line(int start) {
            this(start, start + 1);
        }

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) {
        Ladder T = new Ladder();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
