package com.example.Fproject.Switchcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/on")
    public ResponseEntity<String> turnOn() throws JsonProcessingException {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("Result", "Success");

        String responseJson = new ObjectMapper().writeValueAsString(responseMap);

        // 呼叫 2: 程式中的 sendGetRequestToOtherIP() 方法
        ExampleService exampleService = new ExampleService(new RestTemplateBuilder());
        exampleService.sendGetRequestToOtherIP("http://other-ip:80/on");

        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    @GetMapping("/off")
    public ResponseEntity<String> turnOff() throws JsonProcessingException {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("Result", "Success");

        String responseJson = new ObjectMapper().writeValueAsString(responseMap);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    @GetMapping("/state")
    public ResponseEntity<String> getState() throws JsonProcessingException {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("State", "on");

        String responseJson = new ObjectMapper().writeValueAsString(responseMap);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

}

