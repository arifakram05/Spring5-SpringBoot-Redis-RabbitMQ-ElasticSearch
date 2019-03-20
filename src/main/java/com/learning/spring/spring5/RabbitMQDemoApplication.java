package com.learning.spring.spring5;

import com.learning.spring.spring5.rabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQDemoApplication implements CommandLineRunner {

    @Autowired
    private MessageProducer messageProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQDemoApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        messageProducer.sendMessage("Hello Arif! How are you doing!");
    }
}
