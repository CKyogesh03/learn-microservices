package com.seleniumexpress.employeeapp.repo;

import com.seleniumexpress.employeeapp.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class EmployeeRepo{
    public static Map<Integer,Employee> employeeMap = EmployeeDatabase.getAllEmployees();
    public Optional<Employee> findById(int id){
        if (employeeMap.containsKey(id)){
            return Optional.ofNullable(employeeMap.get(id));
        }
        else {
            return Optional.ofNullable(new Employee());
        }
    }

    public Employee save(Employee e){
        employeeMap.put(e.getId(),e);
        return e;
    }
}