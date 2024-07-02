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
    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private WebClient webClient;

    //it is auto configurable
    @Autowired
    private DiscoveryClient discoveryClient; //use DiscoveryClient interface from springframework and not from the netflix

    public EmployeeResponse getEmployeeById(int id){

        Employee employee = employeeRepo.findById(id).get();
        //mapping using modelmapper
        EmployeeResponse employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
                AddressResponse addressResponse = callToAddressServiceUsingRESTTemplate(id);
                        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
    private AddressResponse callToAddressServiceUsingRESTTemplate(int id){
//        USING DISCOVERYCLIENT
        // open ServiceInstance class and read the methods
        //get me the details for the ip and a port number for address service
        List<ServiceInstance>  instances= discoveryClient.getInstances("address-service"); // getting instance list of address service
        ServiceInstance serviceInstance = instances.get(0);
        String uri = serviceInstance.getUri().toString();

        System.out.println("uri >>>>>>>>>>>> "+uri);
        // note: here we are adding context path manually -> we can overcome this in the LoadBalancerClient section so go and see
        //url,response,urivariable
        return restTemplate.getForObject(uri+"/address-app/api"+"/address/{id}",AddressResponse.class,id);
    }

    public Employee saveEmployee(Employee e){
        employeeRepo.save(e);
        return e;
    }
}
