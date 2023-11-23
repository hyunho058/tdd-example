package com.example.tddexample.inflearn.part1.dfs;

public class Subset {
    private final int number;
    private final int[] ch;

    public Subset(int number) {
        this.number = number;
        this.ch = new int[number + 1];
    }

    public void dfs(int L) {
        if (L <= number) {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L + 1);

            return;
        }

        StringBuilder temp = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            if (ch[i] == 1) {
                temp.append(i);
            }
        }
        if (temp.length() > 0) {
            System.out.println(temp);
        }
    }
}
