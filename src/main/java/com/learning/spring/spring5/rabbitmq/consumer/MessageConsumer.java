package com.learning.spring.spring5.rabbitmq.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageConsumer {

    @RabbitListener(queues = "arif.messages")
    public void getMessages(String message) {
        // This is a listener for queue 'arif.messages', once the message is consumed it is no longer available in RabbitMQ.
        // Here we consume the message as a string.
        log.info("(Log4j2) Received: " + message);
    }

}
