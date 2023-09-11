package com.example.tddexample.inflearn.algorithm_5_1;

import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Parenthesis main = new Parenthesis();
        String result = main.generative(s);

        System.out.println(result);
    }

    public String generative(String s) {

        Stack<Character> openParenthesesStack = new Stack<>();

        if (isOdd(s)) {
            return "NO";
        }

        for (int i = 0; i < s.length(); i++) {

            if (isAnOpenParentheses(openParenthesesStack.isEmpty(), s.charAt(i))) {
                return "NO";
            }

            if (openParenthesesStack.isEmpty() || s.charAt(i) == '(') {
                openParenthesesStack.add(s.charAt(i));
                continue;
            }

            openParenthesesStack.pop();
        }

        if (!openParenthesesStack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

//    isAnOpenParentheses
    private boolean isAnOpenParentheses(boolean isEmpty, char parentheses) {
        return isEmpty && parentheses == ')';
    }

    private boolean isOdd(String s) {
        return s.length() % 2 != 0;
    }
}
