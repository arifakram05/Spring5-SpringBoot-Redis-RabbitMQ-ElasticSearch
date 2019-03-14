package com.learning.spring.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// behind the scenes, @SpringBootApplication is equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan together
@SpringBootApplication
public class Spring5Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Spring5Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Spring5Application.class, args);
	}

}
