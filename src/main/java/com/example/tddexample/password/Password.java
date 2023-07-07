package com.example.tddexample.password;

public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public PasswordStrength validation() {
        int strengthLevel = 0;

        if (this.value.length() >= 8) {
            strengthLevel++;
        }

        if (includedNumbers()) {
            strengthLevel++;
        }

        if (includedUppercaseAlphabets()) {
            strengthLevel++;
        }

        if (strengthLevel == 1) {
            return PasswordStrength.WEAK;
        }

        if (strengthLevel == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.RESISTANT;
    }

    private boolean includedUppercaseAlphabets() {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) >= 'A' && value.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private boolean includedNumbers() {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
