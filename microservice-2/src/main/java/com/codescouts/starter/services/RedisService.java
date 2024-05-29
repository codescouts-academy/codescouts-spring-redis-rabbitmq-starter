package com.codescouts.starter.services;

import com.codescouts.starter.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void set(Test test) {
        redisTemplate.opsForValue().set("test:" + test.id, test.value);
    }

    public Test get(Long id) {
        String value = redisTemplate.opsForValue().get("test:" + id);

        return value != null ? new Test(id, value) : null;
    }
}
