package com.example.Fproject.controller;

import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.IotService.IoTGatewayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import javax.servlet.http.HttpServletRequest;

@Tag(name="IOT control")
@RestController
public class IotController {
    private IoTGatewayService ioTGatewayService;

    public IotController(IoTGatewayService ioTGatewayService) {
        this.ioTGatewayService = ioTGatewayService;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "turn on the light", description = "Turn on the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/{id}/on", method = RequestMethod.GET)
    public void turnOn(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The id is a string composed of 3 digit numbers", example = "001")
                         @PathVariable String id) {
            String result = ioTGatewayService.powerOn(accessToken, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "turn off the light", description = "Turn off the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/{id}/off", method = RequestMethod.GET)
    public void turnOff(@RequestHeader(name = "Authorization") String accessToken,
                          @Parameter(description = "The id is a string composed of 3 digit numbers", example = "001")
                          @PathVariable String id) {
            ioTGatewayService.powerOff(accessToken, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Check the status of the light", description = "Check the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/{id}/state", method = RequestMethod.GET)
    public void getState(@RequestHeader(name = "Authorization") String accessToken,
                           @Parameter(description = "The id is a string composed of 3 digit numbers", example = "001")
                           @PathVariable String id) {
            ioTGatewayService.getState(accessToken, id);
    }

}

