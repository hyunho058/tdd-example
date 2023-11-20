package com.example.tddexample.inflearn.part1.algorithm_6_7;

import java.util.Scanner;

public class Coordinate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] ints = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }

        Coordinate main = new Coordinate();
        int[][] sort = main.sort(ints);

        for (int[] position : sort) {
            System.out.println(position[0] + " " + position[1]);
        }
    }

    public int[][] sort(int[][] ints) {
        for (int i = 1; i < ints.length; i++) {

            for (int j = i; j > 0; j--) {
                int[] temp = new int[2];
                if (this.isSmall(ints[j], ints[j - 1])) {
                    temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                    continue;
                }

                break;
            }
        }

        return ints;
    }

    private boolean isSmall(int[] standard, int[] apostasy) {
        if (standard[0] < apostasy[0]) {
            return true;
        }

        if (standard[0] > apostasy[0]) {
            return false;
        }

        return standard[1] < apostasy[1];
    }


    //    public static void main(String[] args) {
    //        Scanner scanner = new Scanner(System.in);
    //        int n = scanner.nextInt();
    //
    //        int[][] ints = new int[n][2];
    //
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < 2; j++) {
    //                ints[i][j] = scanner.nextInt();
    //            }
    //        }
    //
    //        Coordinate main = new Coordinate();
    //        LinkedList<Position> sort = main.sort(ints);
    //
    //        for (Position position : sort) {
    //            System.out.println(position.toString());
    //        }
    //    }
    //
    //    public LinkedList<Position> sort(int[][] ints) {
    //        LinkedList<Position> positions = new LinkedList<>();
    //
    //        for (int[] anInt : ints) {
    //            positions.add(new Position(anInt[0], anInt[1]));
    //        }
    //
    //        for (int i = 1; i < ints.length; i++) {
    //
    //            for (int j = i; j > 0; j--) {
    //                if (positions.get(j).isSmall(positions.get(j-1))) {
    //                    Position removed = positions.remove(j);
    //                    positions.add(j - 1, removed);
    //                    continue;
    //                }
    //
    //                break;
    //            }
    //        }
    //
    //        return positions;
    //    }
    //
    //
    //    protected static class Position {
    //        private final int x;
    //        private final int y;
    //
    //        public Position(int x, int y) {
    //            this.x = x;
    //            this.y = y;
    //        }
    //
    //        public boolean isSmall(Position position) {
    //            if (this.x < position.getX()) {
    //                return true;
    //            }
    //
    //            if (this.x > position.getX()) {
    //                return false;
    //            }
    //
    //            return this.y < position.getY();
    //        }
    //
    //        public int getX() {
    //            return x;
    //        }
    //
    //        public int getY() {
    //            return y;
    //        }
    //
    //        @Override
    //        public String toString() {
    //            return this.x + " " + this.y;
    //        }
    //    }
}
