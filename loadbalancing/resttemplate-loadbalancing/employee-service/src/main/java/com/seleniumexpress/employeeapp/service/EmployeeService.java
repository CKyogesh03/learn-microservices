package com.seleniumexpress.employeeapp.service;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepo;
import com.seleniumexpress.employeeapp.response.AddressResponse;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    //modelmapper dependency added in pom.xml
    @Autowired
    private ModelMapper modelMapper;

//    //it is auto configurable
//    @Autowired
//    private DiscoveryClient discoveryClient; //use DiscoveryClient interface from springframework and not from the netflix
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient; // from client package

    @Autowired
    private RestTemplate restTemplate;

    public EmployeeResponse getEmployeeById(int id){

        Employee employee = employeeRepo.findById(id).get();
        //mapping using modelmapper
        EmployeeResponse employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
                AddressResponse addressResponse = callToAddressServiceUsingRESTTemplate(id);
                        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
    private AddressResponse callToAddressServiceUsingRESTTemplate(int id){

        return restTemplate.getForObject("http://address-service/address-app/api/address/{id}",AddressResponse.class,id);
    }

    public Employee saveEmployee(Employee e){
        employeeRepo.save(e);
        return e;
    }
}
