package com.example.Fproject.Switchcontroller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExampleService {

    private final RestTemplate restTemplate;

    public ExampleService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void sendGetRequestToOtherIP(String url) {
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }

}
