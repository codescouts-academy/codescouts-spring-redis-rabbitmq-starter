package com.codescouts.starter.services;

import com.codescouts.starter.domain.Test;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "product")
public class RedisRepository {

    @CachePut(value="product",key="#result.id")
    public Test set(Test test) {
        //TODO:

        return test;
    }

    @Cacheable(value="product",key="#id")
    public Test get(Long id) {
        //TODO:

        return new Test(20L, "TEST NO EXIST");
    }
}
