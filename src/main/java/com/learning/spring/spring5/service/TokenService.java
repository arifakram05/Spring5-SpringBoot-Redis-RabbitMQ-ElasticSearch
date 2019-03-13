package com.learning.spring.spring5.service;

public interface TokenService {

    boolean isTokenValid(String token);

    void createToken(String userId);

    String getToken(String userId);
}
