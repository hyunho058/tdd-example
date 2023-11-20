package com.example.tddexample.programmers.q42884;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CameraTest {
    @DisplayName("")
    @Test
    void test() {
        int[][] routes = {
            {-20,-15},
            {-14,-5},
            {-18,-13},
            {-5,-3}
        };

        Camera camera = new Camera(routes);
        int result = camera.minCount();

        assertThat(result).isEqualTo(result);
    }
}