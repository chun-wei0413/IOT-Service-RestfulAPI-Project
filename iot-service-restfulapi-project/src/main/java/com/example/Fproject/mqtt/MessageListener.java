package com.example.Fproject.mqtt;

import com.example.Fproject.rabbitmq.RabbitmqConfig;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;
@Component
public class MessageListener implements IMqttMessageListener {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitmqConfig rabbitmqConfig;
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        String payload = new String(mqttMessage.getPayload(), StandardCharsets.UTF_8);
        LOGGER.info(String.format("MQTT: 订阅主题[%s]发来消息[%s]", topic, new String(mqttMessage.getPayload())));
        rabbitTemplate.convertAndSend(rabbitmqConfig.IOTSTATE_EXCHANGE,"",payload);
    }
}
