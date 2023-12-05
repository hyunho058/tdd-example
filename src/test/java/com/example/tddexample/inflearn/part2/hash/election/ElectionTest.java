package com.example.tddexample.inflearn.part2.hash.election;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElectionTest {
    @Test
    void testCase1() {
        String[] votes = new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"};
        int k = 2;

        Election election = new Election();
        String student = election.solution(votes, k);

        assertThat(student).isEqualTo("daniel");
    }

    @Test
    void testCase2() {
        String[] votes = new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"};
        int k = 3;

        Election election = new Election();
        String student = election.solution(votes, k);

        assertThat(student).isEqualTo("john");
    }

    @DisplayName("문자열이 사전순서로 뒤에있이면 높으면 3을 반환")
    @Test
    void compareTo() {
        String a = "abc";
        String b = "aef";

        System.out.println(a.compareTo(b));

        String a1 = "aef";
        String b1 = "abc";
        System.out.println(a1.compareTo(b1));
    }
    //Map<String, List<String>>
    //tom List.of(john, luis, daniel)
    //k번 이상 받은 받은  학생 찾는다.
    //선물 받은 수 map<String, Integer>

//"john tom",
//"daniel luis",
//"john luis",
//"luis tom",
//"daniel tom",
//"luis john"
}
