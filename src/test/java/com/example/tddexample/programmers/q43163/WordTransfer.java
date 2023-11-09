package com.example.tddexample.programmers.q43163;

public class WordTransfer {
    private final String target;
    private final String[] words;
    private final int visited[];
    private int minimumTransfer = Integer.MAX_VALUE;

    public WordTransfer(String target, String[] words) {
        this(
                target,
                words,
                new int[words.length]
        );
    }

    public WordTransfer(String target, String[] words, int[] visited) {
        this.target = target;
        this.words = words;
        this.visited = visited;
    }

    public int count(String word) {
        dfs(0, word);
        return minimumTransfer == Integer.MAX_VALUE ? 0 : minimumTransfer;
    }

    private void dfs(int level, String word) {

        if (target.equals(word)) {
            if (minimumTransfer > level) {
                minimumTransfer = level;
            }
            return;
        }

        if (level == words.length) {
            return;
        }

        for (int i = 0; i < words.length; i++) {

            if (visited[i] == 1) {
                continue;
            }

            if (notOneDifference(word, words[i])) {
                continue;
            }

            visited[i] = 1;
            dfs(level + 1, words[i]);
            visited[i] = 0;
        }
    }

    private boolean notOneDifference(String word1, String WORD2) {
        int gapCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == WORD2.charAt(i)) {
                continue;
            }

            gapCount++;
        }

        return gapCount != 1;
    }

}
