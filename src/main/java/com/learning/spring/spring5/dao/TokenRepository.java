package com.learning.spring.spring5.dao;

public interface TokenRepository {

    void saveToken(String token, boolean isValid);

    boolean isTokenValid(String token);

}
