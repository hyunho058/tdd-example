package com.example.tddexample.treason;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}
