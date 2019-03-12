package com.learning.spring.spring5.service;

public interface TokenService {

    void setToken(String token);

    boolean isTokenValid(String token);
}
