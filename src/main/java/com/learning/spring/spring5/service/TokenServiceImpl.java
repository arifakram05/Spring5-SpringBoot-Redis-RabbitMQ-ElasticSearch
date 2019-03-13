package com.learning.spring.spring5.service;

import com.learning.spring.spring5.dao.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public String getToken(String userId) {
        return tokenRepository.getToken(userId);
    }
}
