package com.learning.spring.spring5.service;

import com.learning.spring.spring5.dao.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public void setToken(final String token) {
        tokenRepository.saveToken(token, true);
    }

    @Override
    public boolean isTokenValid(final String token) {
        return tokenRepository.isTokenValid(token);
    }
}
