package com.example.tddexample.treason;

import lombok.Getter;

@Getter
public class User {
    private String id;
    private String password;
    private String email;

    protected User() {
    }

    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }
}
