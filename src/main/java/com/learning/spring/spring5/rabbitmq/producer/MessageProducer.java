package com.learning.spring.spring5.rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.spring.spring5.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(String queue, String message) {
        // We are sending our message to default exchange.
        // All messages to RabbitMQ should be sent in byte array; spring will take care of this for us.
        log.info("Writing data: " + message);
        rabbitTemplate.convertAndSend(queue, message);
    }

    public void createEmployee(Employee employee) {
        try {
            String data = objectMapper.writeValueAsString(employee);
            log.info("Writing data: " + data);
            rabbitTemplate.convertAndSend("arif.employees", data);
        } catch (JsonProcessingException e) {
            log.error("Error: ", e);
        }
    }
}
