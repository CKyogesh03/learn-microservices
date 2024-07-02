package com.seleniumexpress.employeeapp.openfeignclient;


import com.seleniumexpress.employeeapp.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ADDRESS-SERVICE",path="/address-app/api")  // our service name registered in the eureka discovery service
//must give context path otherwise path will not be included when using it
public interface AddressClient { // proxy
    @GetMapping("/address/{employeeId}")  // base url is taken from the above @FeignClient
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id);
}
