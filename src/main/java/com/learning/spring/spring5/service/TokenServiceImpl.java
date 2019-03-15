package com.learning.spring.spring5.service;

import com.learning.spring.spring5.dao.TokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public boolean isTokenValid(final String token) {
        return tokenRepository.isTokenValid(token);
    }

    @Override
    public void createToken(String userId) {
        tokenRepository.createTokenForUser(userId, UUID.randomUUID().toString());
    }

    @Cacheable(value = "tokenCache", key = "#userId")
    @Override
    public String getToken(String userId) {
        log.debug("Fetching user Id from database...");
        return tokenRepository.getToken(userId);
    }
}
