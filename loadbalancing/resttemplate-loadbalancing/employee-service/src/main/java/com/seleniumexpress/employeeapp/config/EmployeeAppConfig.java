package com.seleniumexpress.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


   //note: it will fetch the specific instance ip, host from the eureka discovery so we dont need to provide when communicating to the services.
   // just use the service name to fetch details when using rest template to communicate.
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
