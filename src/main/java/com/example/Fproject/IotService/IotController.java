package com.example.Fproject.IotService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


@RestController
public class IotController {

    private IoTGatewayService ioTGatewayService;

    @Operation(summary = "turn on the light", description = "Turn on the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/on", method=RequestMethod.GET)
    public String turnOn(@RequestHeader(name = "Authorization") String accessToken,
                     @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                     @PathVariable String id){
        String result = ioTGatewayService.powerOn(accessToken, id);
        return result;
    }

    @Operation(summary = "turn off the light", description = "Turn off the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/off", method=RequestMethod.GET)
    public String turnOff(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        String result = ioTGatewayService.powerOff(accessToken, id);
        return result;
    }
    @Operation(summary = "Check the status of the light", description = "Check the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/state", method=RequestMethod.GET)
    public String getState(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        String result = ioTGatewayService.powerOff(accessToken, id);
        return result;
    }
    @Operation(summary = "modify device", description = "Modify the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/alter", method=RequestMethod.PUT)
    public String alterDevice(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        return "Success";
    }

    @Operation(summary = "delete device", description = "Delete the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/delete", method=RequestMethod.DELETE)
    public String String (@RequestHeader(name = "Authorization") String accessToken,
                          @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        boolean s= ioTGatewayService.deleteDevice(accessToken, id);
        if(s==true) return "Success";
        else return "error";
    }

    @Operation(summary = "add new device", description = "Add a device without authentication")
    @RequestMapping(value="/devices/new", method=RequestMethod.POST)
    public String addDevice(){
        return "Success";
    }
}

