package com.example.tddexample.inflearn.bfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalfTest {
    @Test
    void test(){
        Calf calf = new Calf();
        int result = calf.bfs(5, 14);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void test1(){
        Calf calf = new Calf();
        int result = calf.bfs(13, 35);

        assertThat(result).isEqualTo(6);
    }

}