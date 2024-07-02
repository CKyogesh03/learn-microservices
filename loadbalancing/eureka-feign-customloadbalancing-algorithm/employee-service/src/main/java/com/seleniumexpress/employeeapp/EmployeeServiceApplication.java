package com.seleniumexpress.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// FIX THE ERROR IN SERVICE LAYER WHEN HITTING ENDPOINT- NULL DATA IS GETTING
//PENDING FROM: TIME 52nd minute in the youtube video 8th video
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  // creates bean
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
}