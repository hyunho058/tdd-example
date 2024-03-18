package com.example.tddexample.inflearn.part2.dfs;

import java.util.Arrays;

public class BigNumber {
    private int answer = -1;
    private boolean flag = false;
    private boolean[] checked;
    //순열. 오름차순
    public int solution(int n) {
        //오름차순 정렬
        int[] originNumberArr = convertToIntArray(n);
        int[] sortedNumberArr = Arrays.copyOf(originNumberArr, originNumberArr.length);
        Arrays.sort(sortedNumberArr);

        checked = new boolean[originNumberArr.length];

        //다음 으로 큰수 찾기 DFS
        dfs(originNumberArr, sortedNumberArr, 0, 0,0, n);

        return answer;
    }

    private void dfs(int[] origin, int[] sorted, int idx, int number, int temp ,int n) {
        if (idx == origin.length) {
            System.out.println(number);
            if (number > n) {
                answer = number;
                flag = true;
            }
        }

        if (flag) {
            return;
        }

        for (int i = 0; i < origin.length; i++) {
            if (checked[i]) {
                continue;
            }

            if ((temp * 10) + origin[idx] > (number * 10) + sorted[i]) {
                continue;
            }

            checked[i] = true;
            dfs(origin, sorted, idx+1, (number * 10) + sorted[i],(temp * 10) + origin[idx], n);
            checked[i] = false;
        }
    }

    private int[] convertToIntArray(int number) {
        String strNumber = String.valueOf(number);
        String[] strNumberArr = strNumber.split("");

        return Arrays.stream(strNumberArr)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}