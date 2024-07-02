package com.seleniumexpress.employeeapp.config;

import com.seleniumexpress.employeeapp.feignclient.AddressClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {
    @Value("${addressservice.base.url}")
    private String addressBaseURL;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


//    add dependency - openfeign


}