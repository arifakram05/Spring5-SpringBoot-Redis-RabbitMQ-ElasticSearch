package com.learning.spring.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// behind the scenes, @SpringBootApplication is equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan together
public class Spring5Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring5Application.class, args);
	}

}
