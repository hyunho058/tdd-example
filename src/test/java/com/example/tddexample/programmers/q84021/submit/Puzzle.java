package com.example.tddexample.programmers.q84021.submit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Puzzle {
    private final int[][] game_board;
    private final int[][] table;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {-1, 0, 1, 0};

    public Puzzle(int[][] game_board, int[][] table) {
        this.game_board = game_board;
        this.table = table;
    }


    public int solution() {
        List<BlockInfo> patterns = bfs(game_board, 0);
        List<BlockInfo> blocks = bfs(table, 1);

        int result = 0;

        for (int i = 0; i < blocks.size(); i++) {
            BlockInfo block = blocks.get(i);

            for (int j = 0; j < patterns.size(); j++) {
                BlockInfo pattern = patterns.get(j);

                System.out.println("pattern.isUsed( = " + pattern.isUsed());
                if (pattern.isUsed()) {
                    continue;
                }

                if (!block.isSameSize(pattern.getSize().getWidth(), pattern.getSize().getLength())) {
                    continue;
                }

                if (block.isSamePattern(pattern.getBlock())) {
                    pattern.use();
                    result += block.getCount();
                    break;
                }
            }
        }

        return result;
    }


    private List<BlockInfo> bfs(int[][] board, int blockNumber) {
        Queue<Point> queue = new LinkedList<>();
        List<BlockInfo> blocks = new ArrayList<>();

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {

                if (board[y][x] != blockNumber) {
                    continue;
                }

                queue.offer(new Point(y, x));

                Point minimumPoint = new Point(51, 51);
                Point maximumPoint = new Point(0, 0);
                List<Point> pointList = new ArrayList<>();

                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    pointList.add(point);
                    board[point.getY()][point.getX()] = 2;

                    minimumPoint = point.small(minimumPoint);
                    maximumPoint = point.large(maximumPoint);

                    for (int i = 0; i < dx.length; i++) {
                        int nextX = point.getX() + dx[i];
                        int nextY = point.getY() + dy[i];

                        if (nextX < 0 || nextX > board[0].length - 1 || nextY < 0 || nextY > board.length - 1) {
                            continue;
                        }

                        if (board[nextY][nextX] != blockNumber) {
                            continue;
                        }

                        board[nextY][nextX] = 2;
                        queue.offer(new Point(nextY, nextX));
                    }

                    if (queue.isEmpty()) {
                        int xSize = maximumPoint.getX() - minimumPoint.getX() + 1;
                        int ySize = maximumPoint.getY() - minimumPoint.getY() + 1;
                        int[][] pattern = new int[ySize][xSize];

                        for (Point p : pointList) {
                            pattern[p.getY() - minimumPoint.getY()][p.getX() - minimumPoint.getX()] = 1;
                        }

                        blocks.add(
                                new BlockInfo(
                                        new BlockSize(xSize, ySize),
                                        pointList.size(),
                                        pattern
                                )
                        );
                    }
                }
            }
        }

        return blocks;
    }

    protected static class Point {
        private final int y;
        private final int x;


        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Point small(Point point) {
            if (this.y < point.getY() || this.x < point.getX()) {
                int minX = Math.min(this.x, point.getX());
                int minY = Math.min(this.y, point.getY());

                return new Point(minY, minX);
            }

            return point;
        }

        public Point large(Point point) {
            if (this.y >= point.getY() || this.x >= point.getX()) {
                int maxX = Math.max(this.x, point.getX());
                int maxY = Math.max(this.y, point.getY());

                return new Point(maxY, maxX);
            }

            return point;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    public static class BlockInfo {

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
            for (int i = 0; i < 3; i++) {
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
