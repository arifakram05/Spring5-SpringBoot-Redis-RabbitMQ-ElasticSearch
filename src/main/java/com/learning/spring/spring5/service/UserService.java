package com.learning.spring.spring5.service;

import com.learning.spring.spring5.model.User;

import java.util.List;

public interface UserService {

    void createUsers();

    long getUserCount();

    User getUserById(String id);

    List<User> getUsersByPattern(String query);

    List<User> getUsersByGivenName(String name);
}
