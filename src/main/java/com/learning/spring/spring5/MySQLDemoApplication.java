package com.learning.spring.spring5;

import com.learning.spring.spring5.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class MySQLDemoApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MySQLDemoApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        try {
            userService.saveUser();
            userService.getUsers();
        } catch (Exception e) {
            log.error("Error Details: ", e);
        }
    }
}
