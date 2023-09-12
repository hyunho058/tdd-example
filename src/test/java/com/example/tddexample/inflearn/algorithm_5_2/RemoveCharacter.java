package com.example.tddexample.inflearn.algorithm_5_2;

import java.util.Scanner;
import java.util.Stack;

public class RemoveCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        RemoveCharacter main = new RemoveCharacter();
        String result = main.removal(s);

        System.out.println(result);
    }
    public String removal(String s) {
        Stack<Character> bracketStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                bracketStack.add(s.charAt(i));
                continue;
            }

            if (bracketStack.isEmpty()) {
                stringBuilder.append(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == ')') {
                bracketStack.pop();
            }

        }

        return stringBuilder.toString();
    }
}
