package com.example.tddexample.treason;

import lombok.Getter;

@Getter
public class StubWeakPasswordChecker implements WeakPasswordChecker{
    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return this.weak;
    }
}
