package com.learning.spring.spring5.rest;

import com.learning.spring.spring5.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/check/{token}")
    boolean checkTokenIfExists(@PathVariable("token") String token) {
        try {
            return tokenService.isTokenValid(token);
        } catch (Exception e) {
            throw new RuntimeException("Error while checking the token");
        }
    }

    @PostMapping("/create/{userId}")
    void createTokenForUser(@PathVariable("userId") String userId) {
        try {
            tokenService.createToken(userId);
        } catch (Exception e) {
            throw new RuntimeException("Could not create token for the user");
        }
    }

    @GetMapping("/user/{userId}")
    String getTokenAssignedToUser(@PathVariable("userId") String userId) {
        return tokenService.getToken(userId);
    }

}
