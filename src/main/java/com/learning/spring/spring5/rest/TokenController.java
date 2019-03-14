package com.learning.spring.spring5.rest;

import com.learning.spring.spring5.service.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    private static final Logger LOGGER = LogManager.getLogger(TokenController.class);

    @Autowired
    private TokenService tokenService;

    @GetMapping("/check/{token}")
    boolean checkTokenIfExists(@PathVariable("token") String token) {
        try {
            LOGGER.debug("Checking token - " + token);
            return tokenService.isTokenValid(token);
        } catch (Exception e) {
            LOGGER.error("Error occurred while checking the token.", e);
            throw new RuntimeException("Error while checking the token.");
        }
    }

    @PostMapping("/create/{userId}")
    void createTokenForUser(@PathVariable("userId") String userId) {
        try {
            LOGGER.debug("Creating token for user " + userId);
            tokenService.createToken(userId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while creating the token.", e);
            throw new RuntimeException("Could not create token for the user.");
        }
    }

    @GetMapping("/user/{userId}")
    String getTokenAssignedToUser(@PathVariable("userId") String userId) {
        try {
            LOGGER.debug("Fetching token for user " + userId);
            return tokenService.getToken(userId);
        } catch(Exception e) {
            LOGGER.error("Error occurred while fetching the token.", e);
            throw new RuntimeException("Could not fetch the token for the user.");
        }
    }

}
