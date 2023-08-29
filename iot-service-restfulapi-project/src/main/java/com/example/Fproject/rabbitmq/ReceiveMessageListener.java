package com.example.Fproject.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiveMessageListener {
    @Autowired
    private RabbitmqConfig rabbitmqConfig;

    @RabbitListener(queues = {"deviceList-queue"})
    public void receive1(List message){
        System.out.println("Consume message: "+message);
    }

    @RabbitListener(queues = {"iotState-queue"})
    public void receive2(String message){
        System.out.println("Consume message: "+message);
    }

    @RabbitListener(queues = {"managerList-queue"})
    public void receive3(List message) {
        System.out.println("Consume message: "+message);
    }
}
