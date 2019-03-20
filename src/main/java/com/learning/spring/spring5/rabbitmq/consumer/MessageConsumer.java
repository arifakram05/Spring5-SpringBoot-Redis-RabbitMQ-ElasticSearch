package com.learning.spring.spring5.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.spring.spring5.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class MessageConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "arif.messages")
    public void getMessages(String message) {
        // This is a listener for queue 'arif.messages', once the message is consumed it is no longer available in RabbitMQ.
        // Here we consume the message as a string.
        log.info("Received Message: " + message);
    }

    @RabbitListener(queues = "arif.employees")
    public void getEmployees(String message) {
        Employee employee = null;
        try {
            employee = objectMapper.readValue(message, Employee.class);
        } catch (IOException e) {
            log.error("Error: ", e);
        }
        log.info("Received Employee Info: " + employee);
    }
}
