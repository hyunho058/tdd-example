package com.example.tddexample.programmers.q84021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleTest {

    @DisplayName("")
    @Test
    void test() {
        int[][] game_board = {
                {1,1,0,0,1,0},
                {0,0,1,0,1,0},
                {0,1,1,0,0,1},
                {1,1,0,1,1,1},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0}

//                {1,1,2,2,1,2},
//                {2,2,1,2,1,2},
//                {2,1,1,2,2,1},
//                {1,1,2,1,1,1},
//                {1,2,2,2,1,2},
//                {0,1,1,1,2,2}

//                {1,1,2,2,1,2}
//                {2,2,1,2,1,2}
//                {2,1,1,2,2,1}
//                {1,1,2,1,1,1}
//                {1,2,2,2,1,2}
//                {2,1,1,1,2,2}
        };
        int[][] table = {
                {1,0,0,1,1,0},
                {1,0,1,0,1,0},
                {0,1,1,0,1,1},
                {0,0,1,0,0,0},
                {1,1,0,1,1,0},
                {0,1,0,0,0,0}
        };

        Puzzle puzzle = new Puzzle(game_board, table);
        int result = puzzle.solution();

        Assertions.assertThat(result).isEqualTo(14);
    }

    @DisplayName("")
    @Test
    void test1() {
        int[][] game_board = {
                {0,0,0},
                {1,1,0},
                {1,1,1}

        };
        int[][] table = {
                {1,1,1},
                {1,0,0},
                {0,0,0}
        };

        Puzzle puzzle = new Puzzle(game_board, table);
        int result = puzzle.solution();

        Assertions.assertThat(result).isEqualTo(0);
    }
}
