package com.learning.spring.spring5.dao;

public interface TokenRepository {

    boolean isTokenValid(String token);

    void createTokenForUser(String userId, String token);

    String getToken(String token);

}
