package com.example.tddexample.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int addition(String s) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(s);

        String separator = ",|:";
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            separator += "|" + customSeparator;
            s = matcher.group(2);
        }

        String[] operands = s.split(separator);

        int sum = 0;
        for (String operand : operands) {
            int number = Integer.parseInt(operand);
            sum += number;
        }

        return sum;
    }
}
