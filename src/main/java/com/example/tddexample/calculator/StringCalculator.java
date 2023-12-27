package com.example.tddexample.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int addition(String text) {
        if (isBlank(text)) {
            return 0;
        }

        if (includedNegative(text)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        String[] operands = split(text);

        return sum(toInt(operands));
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        String separator = ",|:";
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            separator += "|" + customSeparator;
            text = matcher.group(2);
        }

        return text.split(separator);
    }

    private int sum(int[] operands) {
        int sum = 0;
        for (int operand : operands) {
            sum += operand;
        }

        return sum;
    }

    private int[] toInt(String[] operands) {
        int[] numbers = new int[operands.length];
        for (int i = 0; i < operands.length; i++) {
            numbers[i] = Integer.parseInt(operands[i]);
        }

        return numbers;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private boolean includedNegative(String text) {
        return text.contains("-");
    }

}
