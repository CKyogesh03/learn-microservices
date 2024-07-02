package com.seleniumexpress.employeeapp.service;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepo;
import com.seleniumexpress.employeeapp.response.AddressResponse;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    //modelmapper dependency added in pom.xml
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WebClient webClient;

//    //TRADITIONAL MODEL MAPPING
//    public EmployeeResponse getEmployeeById(int id){
//        Employee employee = employeeRepo.findById(id).get();
//
//        //normal manual mapping -> older way-> transferring our data to dummy object
//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setEmail(employee.getEmail());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());
//        return employeeResponse;
//    }

    public EmployeeResponse getEmployeeById(int id){

        Employee employee = employeeRepo.findById(id).get();
        //mapping using modelmapper
        EmployeeResponse employeeResponse=modelMapper.map(employee,EmployeeResponse.class);

        //url,response,urivariable
//        AddressResponse addressResponse = restTemplate.getForObject(addressBaseURL+"/address/{id}",AddressResponse.class,id);
                AddressResponse addressResponse = webClient
                                                .get()
                                                .uri("/address/"+id)
                                                .retrieve()
                                                .bodyToMono(AddressResponse.class)
                                                .block();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

    public Employee saveEmployee(Employee e){
        employeeRepo.save(e);
        return e;
    }
}
