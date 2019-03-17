package com.learning.spring.spring5.rest;

import com.learning.spring.spring5.model.User;
import com.learning.spring.spring5.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create-many")
    public void createManyRandomUsers() {
        try {
            log.info("Creating many random users");
            userService.createUsers();
        } catch (Exception e) {
            log.error("Error occurred while creating random users.", e);
            throw new RuntimeException("Could not create users.");
        }
    }

    @GetMapping("/count")
    public long getUserCount() {
        return userService.getUserCount();
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<User> getUsersByGivenPattern(@RequestParam(name = "query") String query) {
        return userService.getUsersByPattern(query);
    }

    @GetMapping("/search-by-name")
    public List<User> getUsersByGivenName(@RequestParam(name = "name") String name) {
        return userService.getUsersByGivenName(name);
    }
}
