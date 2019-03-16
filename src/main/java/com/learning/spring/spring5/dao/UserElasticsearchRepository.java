package com.learning.spring.spring5.dao;

import com.learning.spring.spring5.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserElasticsearchRepository extends ElasticsearchRepository<User, String> {

    List<User> getUsersByLastName(String lastName);

    List<User> getUsersByFirstNameOrLastNameContaining(String firstName, String lastName);
}
