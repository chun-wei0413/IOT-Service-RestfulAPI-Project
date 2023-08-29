package com.example.Fproject.controller;

import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.handler.IoTHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import com.example.Fproject.rabbitmq.RabbitmqConfig;

@Tag(name="IOT control Services API")
@RestController
public class IotController {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private IoTHandler ioTHandler;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitmqConfig rabbitmqConfig;
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "turn on the light", description = "Turn on the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/on", method = RequestMethod.GET)
    public String turnOn(@Valid @RequestBody IotBean.PowerOnBean powerOnBean) throws MqttException {
        return ioTHandler.powerOn(powerOnBean);
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "turn off the light", description = "Turn off the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/off", method = RequestMethod.GET)
    public String turnOff(@Valid @RequestBody IotBean.PowerOffBean powerOffBean) throws MqttException {
        return ioTHandler.powerOff(powerOffBean);
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Check the status of the light", description = "Check the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/state", method = RequestMethod.GET)
    public String getState(@Valid @RequestBody IotBean.GetStateBean getStateBean) throws MqttException, InterruptedException {
        String state = ioTHandler.getState(getStateBean);
        return state;
    }

}

