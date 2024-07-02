package com.seleniumexpress.employeeapp.feignclient;

import com.seleniumexpress.employeeapp.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8082/address-app/api/address/1
//@FeignClient(name = "address-service",url = "http://localhost:8082/address-app/api/") // base url // name is must to mention otherwise exception will occur
//above name is best practice to use. this will helps in eureka service discovery
@FeignClient(name = "address-service",url = "http://localhost:8082",path = "/address-app/api/")
@RibbonClient(name = "address-service")
public interface AddressClient { //proxy class
    @GetMapping("/address/{employeeId}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id);
}