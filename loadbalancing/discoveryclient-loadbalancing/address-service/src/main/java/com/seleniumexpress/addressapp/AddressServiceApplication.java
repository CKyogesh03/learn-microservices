package com.seleniumexpress.addressapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//note: my 2nd instance is not registering to eureka server check why. only first registered instance only registering
@SpringBootApplication
@EnableDiscoveryClient
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}
}