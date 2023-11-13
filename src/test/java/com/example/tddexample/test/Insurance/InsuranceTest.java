package com.example.tddexample.test.Insurance;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InsuranceTest {
    @DisplayName("보험 항목 목록에서 n개이상의 상품을 선택 해서 특정 값 이하의 상품 조합을 찾는다.")
    @Test
    void test() {
        int k = 3;
        int t = 11;
        int[] arr = {2, 5, 3, 8, 1};

        Insurance insurance = new Insurance();
        int result = insurance.solution(arr, k, t);

        assertThat(result).isEqualTo(6);

    }

    @DisplayName("보험 항목 목록에서 n개이상의 상품을 선택 해서 특정 값 이하의 상품 조합을 찾는다.")
    @Test
    void test1() {
        int k = 2;
        int t = 3;
        int[] arr = {1,1,2,2};

        Insurance insurance = new Insurance();
        int result = insurance.solution(arr, k, t);

        assertThat(result).isEqualTo(5);

    }

    @DisplayName("보험 항목 목록에서 n개이상의 상품을 선택 해서 특정 값 이하의 상품 조합을 찾는다.")
    @Test
    void test2() {
        int k = 2;
        int t = 2;
        int[] arr = {1,2,3,2,};

        Insurance insurance = new Insurance();
        int result = insurance.solution(arr, k, t);

        assertThat(result).isEqualTo(0);

    }

}