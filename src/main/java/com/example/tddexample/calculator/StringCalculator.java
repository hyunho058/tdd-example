package com.example.tddexample.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int addition(String text) {

        if (includedNegative(text)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        String separator = ",|:";
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            separator += "|" + customSeparator;
            text = matcher.group(2);
        }

        String[] operands = text.split(separator);

        int sum = 0;
        for (String operand : operands) {
            int number = Integer.parseInt(operand);

            sum += number;
        }

        return sum;
    }

    private boolean includedNegative(String text) {
        return text.contains("-");
    }
}
