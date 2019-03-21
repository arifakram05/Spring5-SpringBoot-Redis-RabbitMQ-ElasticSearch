package com.learning.spring.spring5.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.spring.spring5.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class MessageConsumer {

    /*
        - Naming convention for exchange and queue.
        - One producer and One consumer
        - One producer and many consumers.
        - Consumer just re-queues when there is an error while message consumption.
        - Creating Dead Letter Exchanges and associating queues to use DLXs (i.e. Moving messages from one queue to another queue upon
        error)

     */
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "arif.messages")
    public void getMessages(String message) {
        // This is a listener for queue 'arif.messages', once the message is consumed it is no longer available in RabbitMQ.
        // Here we consume the message as a string.
        log.info("Reading message.....");
        /* If there happens to be an error while consuming, spring just keeps retrying consumption from queue indefinitely (unless
           otherwise told not to do so).
           Uncomment below code to see this in action. */
        /*if (message != null)
            throw new IllegalArgumentException("Illegal message...cannot consume");*/
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

    @RabbitListener(queues = "q.messages")
    public void failedMessageMovedToFailedQueue(String message) {
        // Since this consumer fails to consume the message, the message no longer lives in q.messages queue.
        // Since q.messages queue uses DLX, the failed message is moved to a q.messages.dlx queue.
        log.info("Reading message.....");
        if (message != null)
            throw new AmqpRejectAndDontRequeueException("Illegal message...cannot consume");
    }
}
