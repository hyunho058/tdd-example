package com.example.tddexample.treason;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MemoryUserRepository implements UserRepository{
    private Map<String, User> users = new HashMap<>();
    @Override
    public void save(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
