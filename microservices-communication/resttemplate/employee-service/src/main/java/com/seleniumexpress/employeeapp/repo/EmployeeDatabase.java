package com.seleniumexpress.employeeapp.repo;

import com.seleniumexpress.employeeapp.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDatabase {
    public static Map<Integer,Employee> employeeMap = new HashMap<>();
    public static Map<Integer,Employee> getAllEmployees(){
        Employee e1 =new Employee(1,"Abhilash","abhilash@gmail.com","O +ve");
        Employee e2 =new Employee(2,"ajith","ajith@gmail.com","A -ve");
        Employee e3 =new Employee(3,"yogesh","yogesh@gmail.com","B +ve");
        Employee e4 =new Employee(4,"lakshmana prakash","lakshmanaprakash@gmail.com","B -ve");
        Employee e5 =new Employee(5,"gokul","gokul@gmail.com","A +ve");
        Employee e6 =new Employee(6,"sabeer","sabeer@gmail.com","B +ve");
        Employee e7 =new Employee(7,"lakshmi","lakshmi@gmail.com","A -ve");
        Employee e8 =new Employee(8,"yuvasri","yuvasri@gmail.com","O +ve");
        Employee e9 =new Employee(9,"dinesh","dinesh@gmail.com","A +ve");
        Employee e10 =new Employee(10,"cholan","cholan@gmail.com","B -ve");
        employeeMap.put(e1.getId(),e1);
        employeeMap.put(e2.getId(),e2);
        employeeMap.put(e3.getId(),e3);
        employeeMap.put(e4.getId(),e4);
        employeeMap.put(e5.getId(),e5);
        employeeMap.put(e6.getId(),e6);
        employeeMap.put(e7.getId(),e7);
        employeeMap.put(e8.getId(),e8);
        employeeMap.put(e9.getId(),e9);
        employeeMap.put(e10.getId(),e10);
        return employeeMap;
    }
}
