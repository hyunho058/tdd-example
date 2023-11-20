package com.example.tddexample.inflearn.part1.dfs.hydrate;

import java.util.Scanner;

public class Hydrate {
    private final int c;
    private final int[] weightArr;
    private int result = 0;

    public Hydrate(int c, int[] weightArr) {
        this.c = c;
        this.weightArr = weightArr;
    }

    public void dfs(int l, int sum) {
        if (sum > c) {
            return;
        }

        if (sum > result) {
            result = sum;
        }

        if (l == weightArr.length) {
            return;
        }

        dfs(l + 1, sum + weightArr[l]);
        dfs(l + 1, sum);
    }

    public int result() {
        return this.result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int c=scanner.nextInt();
        int n=scanner.nextInt();

        int[] weightArr=new int[n];
        for(int i=0; i<n; i++){
            weightArr[i]=scanner.nextInt();
        }
        Hydrate main = new Hydrate(c, weightArr);
        main.dfs(0, 0);
        System.out.println(main.result());
    }
}
