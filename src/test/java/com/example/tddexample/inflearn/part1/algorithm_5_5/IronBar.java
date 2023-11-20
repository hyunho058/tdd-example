package com.example.tddexample.inflearn.part1.algorithm_5_5;

import java.util.Scanner;
import java.util.Stack;

public class IronBar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        IronBar main = new IronBar();
        int result = main.amputation(s);

        System.out.println(result);
    }

    public int amputation(String s) {
        Stack<Character> barStack = new Stack<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (barStack.isEmpty() || c == '(') {
                barStack.push(c);
                continue;
            }

            //레이저 커팅
            if (s.charAt(i - 1) == '(' && c == ')') {
                barStack.pop();
                result += barStack.size();
                continue;
            }

            barStack.pop();
            result ++;
        }

        return result;
    }
}
