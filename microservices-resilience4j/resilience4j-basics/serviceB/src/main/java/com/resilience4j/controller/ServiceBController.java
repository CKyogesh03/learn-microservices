package com.resilience4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceb")
public class ServiceBController {

    //circuit breaker
    @GetMapping("/s2m1")
    public String s2m1(){
        return "s2m1() of service B is called from service A";
    }


}
