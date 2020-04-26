package com.rabbitmq.controller;


import com.rabbitmq.model.Employee;
import com.rabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
        Employee emp = new Employee(empName, empId);
        boolean messageSent = rabbitMQSender.send(emp);
        return "Message sent to the RabbitMQ JavaInUse Successfully - " + messageSent;
    }

    @GetMapping(value = "/sample")
    public String sample() {

        return "Message sent";
    }

}

