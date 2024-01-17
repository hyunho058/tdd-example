package com.example.tddexample.inflearn.part2.sort.place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Place {

    /**
     * board 배열에서 학생들의 위치를 찾아 각각의 x좌표와 y좌표를 리스트에 저장.
     * x좌표와 y좌표 각각에 대해 중간값을 찾는다. (list.size() / 2)
     * 각 학생의 위치에서 이 중간값까지의 맨해튼 거리를 계산.
     * 모든 학생들의 거리의 합을 구한다..
     */
    public int solution(int[][] board) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 0) {
                    continue;
                }

                xList.add(x);
                yList.add(y);
            }
        }
        int xAxisMinDistance = calcSumMinDistance(xList);
        int yAxisMinDistance = calcSumMinDistance(yList);

        return xAxisMinDistance + yAxisMinDistance;
    }

    private int calcSumMinDistance(List<Integer> list) {
        int midLocation = getMidLocation(list);

        int sumDistaence = 0;
        for (int location : list) {
            sumDistaence += Math.abs(location - midLocation);
        }

        return sumDistaence;
    }

    private int getMidLocation(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() / 2);
    }
}
