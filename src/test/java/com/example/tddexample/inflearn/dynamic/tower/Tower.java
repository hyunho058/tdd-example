package com.example.tddexample.inflearn.dynamic.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tower {
    private final int n;
    private final int[][] blockArr;
    private final int[] dynamic;

    public Tower(int n, int[][] blockArr) {
        this.n = n;
        this.blockArr = blockArr;
        this.dynamic = new int[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] blockArr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int area = scanner.nextInt();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();

            blockArr[i][0] = area;
            blockArr[i][1] = height;
            blockArr[i][2] = weight;
        }

        Tower tower = new Tower(n, blockArr);
        int height = tower.maximumHeight();

        System.out.println(height);
    }

    public int maximumHeight() {
        List<Block> blocks = this.initData();
        int maxHeight = 0;

        for (int i = 0; i < blocks.size(); i++) {
            Block bottomBlock = blocks.get(i);
            dynamic[i] = bottomBlock.getHeight();

            for (int j = i - 1; j >= 0; j--) {
                Block block = blocks.get(j);

                if (bottomBlock.isSmall(block.getWeight())) {
                    continue;
                }

                int beforeTowerHeight = bottomBlock.getHeight() + dynamic[j];
                if (dynamic[i] > beforeTowerHeight) {
                    continue;
                }

                dynamic[i] = beforeTowerHeight;

                if (maxHeight < dynamic[i]) {
                    maxHeight = dynamic[i];
                }
            }
        }

        return maxHeight;
    }

    private List<Block> initData() {
        List<Block> blocks = new ArrayList<>();

        for (int[] block : blockArr) {
            int area = block[0];
            int height = block[1];
            int weight = block[2];
            blocks.add(new Block(area, height, weight));
        }
        Collections.sort(blocks);

        return blocks;
    }

    protected static class Block implements Comparable<Block> {
        private final int area;
        private final int height;
        private final int weight;

        public Block(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        public boolean isSmall(int weight) {
            return this.weight < weight;
        }

        @Override
        public int compareTo(Block o) {
            return this.area - o.area;
        }

        public int getArea() {
            return area;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "area=" + area +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }
}
