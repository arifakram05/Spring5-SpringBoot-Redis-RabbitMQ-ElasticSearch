package com.learning.spring.spring5;

import com.learning.spring.spring5.model.Employee;
import com.learning.spring.spring5.rabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class RabbitMQDemoApplication implements CommandLineRunner {

    @Autowired
    private MessageProducer messageProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQDemoApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        // sending message to queue 1
        messageProducer.sendMessage("q.messages", "Hello Arif! How are you doing!");
        // sending message to queue 2
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        String dateInString = "1990-09-05 11:05";
        Date birthDate = dateFormat.parse(dateInString);
        Employee employee = new Employee("1214", "Arif", "Akram", new Date(), birthDate);
        messageProducer.createEmployee(employee);
    }
}
