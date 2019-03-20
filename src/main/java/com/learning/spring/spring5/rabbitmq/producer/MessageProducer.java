package com.learning.spring.spring5.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        // We are sending our message to default exchange.
        // All messages to RabbitMQ should be sent in byte array; spring will take care of this for us.
        // We have specified the queue name as 'arif.messages'
        rabbitTemplate.convertAndSend("arif.messages", message);
    }
}
