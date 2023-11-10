package com.example.tddexample.programmers.q84021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BlockInfoTest {
    @DisplayName("두 2차원 배열(배열1 [2][1], 배열2 [2][1])에 각 값이 같다면 크기는 같다.")
    @Test
    void sameBlock() {
        BlockInfo.BlockSize size = new BlockInfo.BlockSize(1, 2);
        int count = 2;
        int[][] blockA = {
                {1},
                {1}
        };
        BlockInfo blockInfo = new BlockInfo(size, count, blockA);

        int[][] blockB = {{1}, {1}};

        boolean result = blockInfo.isSameSize(blockB[0].length, blockB.length);
        assertThat(result).isTrue();
    }

    @DisplayName("두 2차원 배열(배열1 [2][1], 배열2 [1][2])에 배열1 개로, 배열2 세로 가 같고 배열1 세로, 배열2 가로가 같다면 크기는 같다.")
    @Test
    void sameBlockRotation() {
        BlockInfo.BlockSize size = new BlockInfo.BlockSize(1, 2);
        int count = 2;
        int[][] blockA = {
                {1},
                {1}
        };
        BlockInfo blockInfo = new BlockInfo(size, count, blockA);

        int[][] blockB = {{1, 1}};

        boolean result = blockInfo.isSameSize(blockB[0].length, blockB.length);
        assertThat(result).isTrue();
    }

    @DisplayName("block을 시계방향으로 90도 회전시킨다.")
    @Test
    void blockRotate() {
        BlockInfo.BlockSize size = new BlockInfo.BlockSize(2, 3);
        int count = 4;
        int[][] blockA = {
                {1, 0},
                {1, 1},
                {1, 0}
        };
        BlockInfo blockInfo = new BlockInfo(size, count, blockA);

        int[][] rotateBlock = {
                {1, 1, 1},
                {0, 1, 0}
        };

        int[][] rotated = blockInfo.rotate(blockA);

        assertThat(
                Arrays.deepEquals(rotateBlock, rotated)
        ).isTrue();
    }

    @DisplayName("block과 pattern에 배치된 값이 동일하다면 같은 블록이다.")
    @Test
    void samePattern() {
        BlockInfo.BlockSize size = new BlockInfo.BlockSize(2, 3);
        int count = 4;
        int[][] blockA = {
                {1, 0},
                {1, 1},
                {1, 0}
        };
        BlockInfo blockInfo = new BlockInfo(size, count, blockA);

        int[][] pattern = {
                {1, 0},
                {1, 1},
                {1, 0}
        };

        boolean result = blockInfo.isSamePattern(pattern);

        assertThat(result).isTrue();
    }

    @DisplayName("block과 pattern의 x y size가 달라도 회전시켜 배치된 값이 동일하다면 같은 블록이다.")
    @Test
    void sameRotationPattern() {
        BlockInfo.BlockSize size = new BlockInfo.BlockSize(2, 3);
        int count = 4;
        int[][] blockA = {
                {1, 0},
                {1, 1},
                {1, 0}
        };
        BlockInfo blockInfo = new BlockInfo(size, count, blockA);

        int[][] pattern = {
                {1, 1, 1},
                {0, 1, 0}
        };

        boolean result = blockInfo.isSamePattern(pattern);

        assertThat(result).isTrue();
    }
}
