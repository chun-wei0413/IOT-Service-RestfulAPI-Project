package com.example.Fproject.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitmqConfig {

    public static final String DEVICELIST_EXCHANGE = "deviceList-exchange";
    public static final String DEVICELIST_QUEUE = "deviceList-queue";
    public static final String IOTSTATE_EXCHANGE = "iotState-exchange";
    public static final String IOTSTATE_QUEUE = "iotState-queue";
    public static final String MANAGERLIST_EXCHANGE = "managerList-exchange";
    public static final String MANAGERLIST_QUEUE = "managerList-queue";
    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
    @Bean
    public Queue deviceListQueue(){
        return new Queue(DEVICELIST_QUEUE);
    }
    @Bean
    public FanoutExchange deviceListExchange(){
        return new FanoutExchange(DEVICELIST_EXCHANGE);
    }
    @Bean
    public Queue iotStateQueue(){
        return new Queue(IOTSTATE_QUEUE);
    }
    @Bean
    public FanoutExchange iotStateExchange(){
        return new FanoutExchange(IOTSTATE_EXCHANGE);
    }
    @Bean
    public Queue managerListQueue() { return new Queue(MANAGERLIST_QUEUE);}
    @Bean
    public FanoutExchange managerListExchange(){return new FanoutExchange(MANAGERLIST_EXCHANGE);}
    @Bean
    public Binding DeviceListBinding(){return BindingBuilder.bind(deviceListQueue()).to(deviceListExchange());
    }
    @Bean
    public Binding IoTStateBinding(){
        return BindingBuilder.bind(iotStateQueue()).to(iotStateExchange());
    }
    @Bean
    public Binding ManagerListBinding(){return BindingBuilder.bind(managerListQueue()).to(managerListExchange());}
}
