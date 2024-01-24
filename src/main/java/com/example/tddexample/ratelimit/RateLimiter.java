package com.example.tddexample.ratelimit;

public interface RateLimiter {
    boolean allowRequest(String key);
}
