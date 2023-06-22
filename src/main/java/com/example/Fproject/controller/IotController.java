package com.example.Fproject.controller;

import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.IotService.IoTGatewayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import com.example.Fproject.handler.APIHandler;

@Tag(name="IOT control")
@RestController
public class IotController {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private APIHandler apiHandler;

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "turn on the light", description = "Turn on the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/on", method = RequestMethod.GET)
    public String turnOn(@Valid @RequestBody IotBean.PowerOnBean powerOnBean) {
        return apiHandler.powerOn(powerOnBean);
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "turn off the light", description = "Turn off the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/off", method = RequestMethod.GET)
    public String turnOff(@Valid @RequestBody IotBean.PowerOffBean powerOffBean) {
        return apiHandler.powerOff(powerOffBean);
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Check the status of the light", description = "Check the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/state", method = RequestMethod.GET)
    public String getState(@Valid @RequestBody IotBean.GetStateBean getStateBean) {
        return apiHandler.getState(getStateBean);
    }

}

