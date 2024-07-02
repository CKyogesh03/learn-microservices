package com.resilience4j.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/servicea")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_NAME = "serviceA";
    private static final String BASE_URL_OF_SERVICE_B="http://localhost:8081";

    @CircuitBreaker(name = SERVICE_NAME,fallbackMethod = "m1Fallback")
    @GetMapping("/m1")
    public String m1(){
        String url = BASE_URL_OF_SERVICE_B+"/serviceb";
        return restTemplate.getForObject(url + "/s2m1", String.class);
    }

    public String m1Fallback(Exception e){
        return "This is a fallback method for m1() - server B is down kindly please come after some times";
    }


}
