package com.learning.spring.spring5.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.learning.spring.spring5.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserElasticsearchRepository extends ElasticsearchRepository<User, String> {

    Page<User> findAll(Pageable pageable);

    List<User> getUsersByLastNameContaining(String query);

    List<User> getUsersByFirstNameContaining(String query);

    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"firstName\", \"lastName\"]}}")
    List<User> getUsersByFirstNameOrLastNameContaining(String name);
}
