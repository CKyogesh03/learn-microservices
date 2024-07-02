package com.seleniumexpress.addressapp.repo;

import com.seleniumexpress.addressapp.entity.Address;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class AddressRepo {
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
