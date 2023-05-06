package com.example.Fproject.IotService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.concurrent.Exchanger;


@RestController
public class IotController {

    @Operation(summary = "turn on the light", description = "Turn on the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/on/{id}", method=RequestMethod.GET)
    public ObjectNode turnOn(@RequestHeader(name = "Authorization") String accessToken,
                     @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                     @PathVariable String id){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode(); // 創建一個空的 ObjectNode

        response.put("result", "success"); // 在 ObjectNode 中添加 "result":"success" 鍵值對
        return response;
    }
    /*public ResponseEntity<String> on(HttpServletRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return ResponseEntity.ok().body(response.getBody());
    }*/
    @Operation(summary = "turn off the light", description = "Turn off the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/off/{id}", method=RequestMethod.GET)
    public ObjectNode turnOff(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode(); // 創建一個空的 ObjectNode

        response.put("result", "success"); // 在 ObjectNode 中添加 "result":"success" 鍵值對
        return response;
    }
    @Operation(summary = "Check the status of the light", description = "Check the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/state/{id}", method=RequestMethod.GET)
    public ObjectNode getState(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode(); // 創建一個空的 ObjectNode

        response.put("result", "success"); // 在 ObjectNode 中添加 "result":"success" 鍵值對
        return response;
    }
    @Operation(summary = "modify device", description = "Modify the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/{id}/alter", method=RequestMethod.PUT)
    public ObjectNode alterDevice(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode(); // 創建一個空的 ObjectNode

        response.put("result", "success"); // 在 ObjectNode 中添加 "result":"success" 鍵值對
        return response;
    }

    @Operation(summary = "delete device", description = "Delete the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
    public ObjectNode deleteDevice(@RequestHeader(name = "Authorization") String accessToken,
                         @Parameter(description = "The key is a string composed of 6 digits", example = "ACDE12")
                         @PathVariable String id){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode(); // 創建一個空的 ObjectNode

        response.put("result", "success"); // 在 ObjectNode 中添加 "result":"success" 鍵值對
        return response;
    }

    @Operation(summary = "add new device", description = "Add a device without authentication")
    @RequestMapping(value="/new", method=RequestMethod.POST)
    public ObjectNode addDevice(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode(); // 創建一個空的 ObjectNode

        response.put("result", "success"); // 在 ObjectNode 中添加 "result":"success" 鍵值對
        return response;
    }
}

