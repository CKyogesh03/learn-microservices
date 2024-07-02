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

    @Autowired
    private LoadBalancerClient loadBalancerClient; // from client package

    public EmployeeResponse getEmployeeById(int id){

        Employee employee = employeeRepo.findById(id).get();
        //mapping using modelmapper
        EmployeeResponse employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
                AddressResponse addressResponse = callToAddressServiceUsingRESTTemplate(id);
                        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
    private AddressResponse callToAddressServiceUsingRESTTemplate(int id){
        //USING DISCOVERYCLIENT
//        // open ServiceInstance class and read the methods
//        //get me the details for the ip and a port number for address service
//        List<ServiceInstance>  instances= discoveryClient.getInstances("address-service"); // getting instance list of address service
//        ServiceInstance serviceInstance = instances.get(0);
//        String uri = serviceInstance.getUri().toString();

        //USING LOADBALANCERCLIENT
        ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
        String uri = serviceInstance.getUri().toString();
        String contextRoot = serviceInstance.getMetadata().get("configPath");  //GETTING NULL VALUE
        System.out.println(serviceInstance.getMetadata().get("user")); // GETTING NULL VALUE

        System.out.println("uri >>>>>>>>>>>> "+uri+contextRoot);
        //url,response,urivariable
        return restTemplate.getForObject(uri+contextRoot+"/address/{id}",AddressResponse.class,id);
    }

//    private AddressResponse callToAddressServiceUsingWebClient(int id){
//        return webClient
//                .get()
//                .uri("/address/"+id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();
//    }

    public Employee saveEmployee(Employee e){
        employeeRepo.save(e);
        return e;
    }
}
