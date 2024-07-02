package com.seleniumexpress.addressapp.repo;

import com.seleniumexpress.addressapp.entity.Address;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class AddressRepo {
//    //sql query for Address no1 address: SELECT ea.id, ea.lane1,ea.lane2,ea.state,ea.zip FROM Address_microservice.Address e join address_microservice.address ea on e.id = ea.id where ea.id=1;
//    @Query(nativeQuery = true,value = "SELECT ea.id, ea.lane1,ea.lane2,ea.state,ea.zip FROM Address_microservice.Address e join address_microservice.address ea on e.id = ea.id where ea.id=:AddressId;")
//    Address findAddressByAddressId(@Param("AddressId") int AddressId);

    public static Map<Integer, Address> addressMap = AddressDatabase.getAllAddresss();

    public Optional<Address> findAddressByEmployeeId(int id){
        if (addressMap.containsKey(id)){
            return Optional.ofNullable(addressMap.get(id));
        }
        else {
            return Optional.ofNullable(new Address());
        }
    }

    public Address save(Address e){
        addressMap.put(e.getId(),e);
        return e;
    }
}
