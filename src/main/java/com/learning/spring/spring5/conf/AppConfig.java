package com.learning.spring.spring5.conf;

import com.learning.spring.spring5.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan("com.learning.spring.spring5")
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
        // you can even add interceptors for specific paths. Refer: https://github.com/eugenp/tutorials/blob/master/spring-security-mvc-custom/src/main/java/org/baeldung/spring/MvcConfig.java
        // registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/token/*");
    }
}
