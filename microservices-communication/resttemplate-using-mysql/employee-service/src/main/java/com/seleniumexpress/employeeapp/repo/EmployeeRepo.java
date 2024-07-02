package com.seleniumexpress.employeeapp.repo;

import com.seleniumexpress.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
