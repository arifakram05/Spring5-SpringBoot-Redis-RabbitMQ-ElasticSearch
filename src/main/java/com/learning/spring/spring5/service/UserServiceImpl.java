package com.learning.spring.spring5.service;

import com.learning.spring.spring5.dao.UserElasticsearchRepository;
import com.learning.spring.spring5.model.User;
import me.xdrop.jrand.JRand;
import me.xdrop.jrand.generators.person.FirstnameGenerator;
import me.xdrop.jrand.generators.person.LastnameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserElasticsearchRepository userElasticsearchRepository;
    FirstnameGenerator firstname = JRand.firstname();
    LastnameGenerator lastname = JRand.lastname();

    @Override
    public void createUsers() {
        List<User> users = IntStream.rangeClosed(10000, 10100).mapToObj(id -> {
            User user = new User();
            user.setUserId(String.valueOf(id));
            user.setFirstName(firstname.gen());
            user.setLastName(lastname.gen());
            return user;
        }).collect(Collectors.toList());
        userElasticsearchRepository.saveAll(users);
    }

    @Override
    public long getUserCount() {
        return userElasticsearchRepository.count();
    }

    @Override
    public List<User> getAllUsers(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "_id"));
        return userElasticsearchRepository.findAll(pageable).getContent();
    }

    @Override
    public User getUserById(String id) {
        return userElasticsearchRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsersByPattern(String query) {
        List<User> firstNamesList = userElasticsearchRepository.getUsersByFirstNameContaining(query);
        List<User> lastNamesList = userElasticsearchRepository.getUsersByLastNameContaining(query);
        return Stream.concat(firstNamesList.stream(), lastNamesList.stream()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersByGivenName(String name) {
        return userElasticsearchRepository.getUsersByFirstNameOrLastNameContaining(name);
    }


}
