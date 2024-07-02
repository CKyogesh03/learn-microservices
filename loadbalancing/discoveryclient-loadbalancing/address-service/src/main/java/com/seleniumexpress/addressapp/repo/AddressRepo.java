package com.seleniumexpress.addressapp.repo;

import com.seleniumexpress.addressapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    //sql query for employee no1 address: SELECT ea.id, ea.lane1,ea.lane2,ea.state,ea.zip FROM employee_microservice.employee e join address_microservice.address ea on e.id = ea.id where ea.id=1;
    @Query(nativeQuery = true,value = "SELECT ea.id, ea.lane1,ea.lane2,ea.state,ea.zip FROM employee_microservice.employee e join address_microservice.address ea on e.id = ea.id where ea.id=:employeeId;")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
