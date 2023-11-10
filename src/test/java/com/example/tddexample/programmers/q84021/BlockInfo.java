package com.example.tddexample.programmers.q84021;

import java.util.Arrays;

public class BlockInfo {

    private final BlockSize size;
    private final int count;

    private final int[][] block;
    private boolean used = false;

    public BlockInfo(BlockSize size, int count, int[][] block) {
        this.size = size;
        this.count = count;
        this.block = block;
    }

    public boolean isSameSize(int width, int length) {
        return size.isSame(width, length);
    }

    public int[][] rotate(int[][] block) {
        int width = block[0].length;
        int length = block.length;
        int[][] rotated = new int[width][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                rotated[j][(length - 1) - i] = block[i][j];
            }
        }

        return rotated;
    }

    public boolean isSamePattern(int[][] pattern) {
        if (Arrays.deepEquals(this.block, pattern)) {
            return true;
        }

        int[][] rotatedTempBlock = this.block;
        for (int i = 0; i < 3; i ++) {
            rotatedTempBlock = this.rotate(rotatedTempBlock);

            if (Arrays.deepEquals(rotatedTempBlock, pattern)) {
                return true;
            }
        }

        return Arrays.deepEquals(this.block, pattern);
    }

    public int getCount() {
        return this.count;
    }

    public int[][] getBlock() {
        return this.block;
    }
    public BlockSize getSize() {
        return this.size;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void use() {
        this.used = true;
    }

    protected static class BlockSize {
        private final int width;
        private final int length;

        public BlockSize(int width, int length) {
            this.width = width;
            this.length = length;
        }

        public boolean isSame(int width, int length) {
            if (this.width == width && this.length == length) {
                return true;
            }

            if (this.width == length && this.length == width) {
                return true;
            }

            return false;
        }

        public int getWidth() {
            return width;
        }

        public int getLength() {
            return length;
        }
    }
}
