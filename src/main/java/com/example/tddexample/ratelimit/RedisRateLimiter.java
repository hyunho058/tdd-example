package com.example.tddexample.ratelimit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisRateLimiter implements RateLimiter{

    private final RedisTemplate<String, String> redisTemplate;
    private final String KEY_PREFIX = "rate_limiter:";

    public RedisRateLimiter(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean allowRequest(String key) {
        String redisKey = KEY_PREFIX + key;
        log.info("RedisRateLimiter :: redisKey is {}",redisKey);
        Long currentCount = redisTemplate.opsForValue().increment(redisKey, 1);
        log.info("RedisRateLimiter :: currentCount is {}",currentCount);
        if (currentCount == 1) {
            redisTemplate.expire(redisKey, 1, TimeUnit.SECONDS);
        }

        return currentCount <= 5;
    }
}
