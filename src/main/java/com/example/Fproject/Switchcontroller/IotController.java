package com.example.Fproject.Switchcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class IotController {
    private RestTemplate restTemplate;

    public IotController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/on")
    public ResponseEntity<String> on(HttpServletRequest request) {
        String url = "https://e862-49-216-45-231.ngrok-free.app/on";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return ResponseEntity.ok().body(response.getBody());
    }

    @GetMapping("/off")
    public ResponseEntity<String> off(HttpServletRequest request) {
        String url = "https://e862-49-216-45-231.ngrok-free.app/off";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return ResponseEntity.ok().body(response.getBody());
    }

    @GetMapping("/state")
    public ResponseEntity<String> state(HttpServletRequest request) {
        String url = "https://e862-49-216-45-231.ngrok-free.app/state";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return ResponseEntity.ok().body(response.getBody());
    }

}

