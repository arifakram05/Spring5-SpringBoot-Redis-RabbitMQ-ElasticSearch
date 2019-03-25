package com.learning.spring.spring5.dao;

import com.learning.spring.spring5.model.sql.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRDBMSRepository extends CrudRepository<User, Long> {

}
