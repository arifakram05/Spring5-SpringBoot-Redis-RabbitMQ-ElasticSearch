package com.learning.spring.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TokenRepositoryImpl implements TokenRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean isTokenValid(final String token) {
        return null == redisTemplate.opsForValue().get(token) ? false : true;
    }

    @Override
    public void createTokenForUser(String userId, String token) {
        redisTemplate.opsForValue().set(userId, token);
    }

    @Override
    public String getToken(String userId) {
        return redisTemplate.opsForValue().get(userId).toString();
    }

}
