package com.example.tddexample.inflearn.part2.fruit;

public class Fruit {
    public int solution(int[][] fruit) {
        int answer = 0;
        boolean[] changed = new boolean[fruit.length];

        for (int i = 0; i < fruit.length; i++) {
            if (changed[i]) {
                continue;
            }

            int minIndex = min(fruit[i]);

            if (this.isDuplicateMinimum(fruit[i])) {
                answer += fruit[i][minIndex];
                continue;
            }

            boolean changeStatus = false;
            for (int j = i + 1; j < fruit.length; j++) {
                if (changed[j]) {
                    continue;
                }

                if (this.isDuplicateMinimum(fruit[j])) {
                    continue;
                }

                int comparisonMinIndex = min(fruit[j]);
                if (minIndex == comparisonMinIndex) {
                    continue;
                }

                fruit[i][minIndex]++;
                fruit[i][comparisonMinIndex]--;
                fruit[j][comparisonMinIndex]++;
                fruit[j][minIndex]--;

                if (minIndex != min(fruit[i]) || comparisonMinIndex != min(fruit[j])) {
                    fruit[i][minIndex]--;
                    fruit[i][comparisonMinIndex]++;
                    fruit[j][comparisonMinIndex]--;
                    fruit[j][minIndex]++;
                    continue;
                }

                answer += fruit[j][comparisonMinIndex];
                answer += fruit[i][minIndex];
                changeStatus = true;
                changed[j] = true;
                break;
            }

            if (!changeStatus) {
                answer += fruit[i][minIndex];
            }
        }

        return answer;
    }

    private boolean isDuplicateMinimum(int[] fruitArr) {
        if (fruitArr[0] == fruitArr[1]) {
            return true;
        }
        if (fruitArr[0] == fruitArr[2]) {
            return true;
        }
        if (fruitArr[1] == fruitArr[2]) {
            return true;
        }

        return false;
    }

    private int min(int[] fruitArr) {
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < fruitArr.length; i++) {
            if (minValue > fruitArr[i]) {
                minIndex = i;
                minValue = fruitArr[i];
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        Fruit T = new Fruit();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
