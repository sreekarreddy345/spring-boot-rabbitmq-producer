package com.rabbitmq.service;

import com.rabbitmq.model.Employee;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    public boolean send(Employee employee) {

        try {
            rabbitTemplate.convertAndSend(exchange, routingkey, employee);
            System.out.println("Send msg - " + employee);
            return true;
        } catch (AmqpException e) {
            e.printStackTrace();
            return false;
        }
    }
}
