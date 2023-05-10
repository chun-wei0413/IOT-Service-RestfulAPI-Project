package com.example.Fproject.IotService;

import com.example.Fproject.database.DatabaseService;
import com.example.Fproject.database.entity.device;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import com.example.Fproject.IotService.IoTGatewayService;

@RestController
public class IotController {
    private IoTGatewayService ioTGatewayService;
    public IotController(IoTGatewayService ioTGatewayService) {
        this.ioTGatewayService=ioTGatewayService;
    }
    @Operation(summary = "turn on the light", description = "Turn on the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/on", method=RequestMethod.GET)
    public String turnOn(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id) {
        try {
            String result = ioTGatewayService.powerOn(accessToken, id);
            if (result != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Result", "Success");
                return jsonObject.toString();
            } else {
                throw new NullPointerException("The result of powerOn method is null.");
            }
        } catch (NullPointerException e) {
            // Handle the exception here, such as logging or throwing a custom exception
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Operation(summary = "turn off the light", description = "Turn off the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/off", method=RequestMethod.GET)
    public String turnOff(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        try {
            String result = ioTGatewayService.powerOff(accessToken, id);
            if (result != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Result", "Success");
                return jsonObject.toString();
            } else {
                throw new NullPointerException("The result of poweroff method is null.");
            }
        } catch (NullPointerException e) {
            // Handle the exception here, such as logging or throwing a custom exception
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    @Operation(summary = "Check the status of the light", description = "Check the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/state", method=RequestMethod.GET)
    public String getState(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
            String result = ioTGatewayService.getState(accessToken, id);
            if (result != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("State", result);
                return jsonObject.toString();
            }
            else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("State", "failed");
                return jsonObject.toString();
            }
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
        try {
            boolean result = ioTGatewayService.deleteDevice(accessToken, id);
            if (result != false) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Result", "Success");
                return jsonObject.toString();
            } else {
                throw new NullPointerException("The result of delete method is null.");
            }
        } catch (NullPointerException e) {
            // Handle the exception here, such as logging or throwing a custom exception
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Operation(summary = "add new device", description = "Add a device without authentication")
    @RequestMapping(value="/devices/new", method=RequestMethod.POST)
    public String addDevice(){
        return "Success";
    }
}

