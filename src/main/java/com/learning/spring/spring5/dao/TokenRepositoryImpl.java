package com.learning.spring.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TokenRepositoryImpl implements TokenRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveToken(final String token, final boolean isValid) {
        redisTemplate.opsForValue().set(token, isValid);
    }

    @Override
    public boolean isTokenValid(final String token) {
        return null == redisTemplate.opsForValue().get(token) ? false : true;
    }

}
