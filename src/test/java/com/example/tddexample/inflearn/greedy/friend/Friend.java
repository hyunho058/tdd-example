package com.example.tddexample.inflearn.greedy.friend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Friend {

    private final int n;
    private final int m;
    private final int[][] friendShipArr;
    private final List<List<Integer>> friendShipGraph;
    private final boolean[] visited;

    public Friend(int n, int m, int[][] friendShipArr) {
        this.n = n;
        this.m = m;
        this.friendShipArr = friendShipArr;
        this.friendShipGraph = new ArrayList<>();
        this.visited = new boolean[n + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] friendShipArr = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            friendShipArr[i][0] = a;
            friendShipArr[i][1] = b;
        }

        int current = scanner.nextInt();
        int target = scanner.nextInt();

        Friend friend = new Friend(n, m, friendShipArr);
        String result = friend.find(current, target);
        System.out.println(result);
    }

    public String find(int student, int friend) {
        for (int i = 0; i <= n; i++) {
            friendShipGraph.add(new ArrayList<>());
        }

        for (int[] f : friendShipArr) {
            int leftFriend = f[0];
            int rightFriend = f[1];

            friendShipGraph.get(leftFriend).add(rightFriend);
            friendShipGraph.get(rightFriend).add(leftFriend);
        }

        boolean result = this.dfs(student, friend);

        if (result) {
            return "YES";
        }

        return "NO";
    }

    public boolean dfs(int current, int target) {
        if (current == target) {
            return true;
        }

        visited[current] = true;

        for (int friend : friendShipGraph.get(current)) {
            if (visited[friend]) {
                continue;
            }

            boolean result = dfs(friend, target);
            if (result) {
                return true;
            }

        }

        return false;
    }
}
