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

    @PostMapping("/save/{token}")
    void saveToken(@PathVariable("token") String token) {
        try {
            tokenService.setToken(token);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Could not save the token");
        }
    }

    @GetMapping("/check/{token}")
    boolean checkTokenIfExists(@PathVariable("token") String token) {
        try {
            return tokenService.isTokenValid(token);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Could not save the token");
        }
    }
}
