package com.seleniumexpress.addressapp.repo;

import com.seleniumexpress.addressapp.entity.Address;

import java.util.HashMap;
import java.util.Map;

public class AddressDatabase {
    public static Map<Integer, Address> addressMap = new HashMap<>();
    public static Map<Integer,Address> getAllAddresss(){
        Address e1 =new Address(1,"electronic city","banglore",604204,"tamilnadu");
        Address e2 =new Address(2,"vinayagapuram","chennai",604204,"tamilnadu");
        Address e3 =new Address(3,"thorappadi","chennai",604204,"tamilnadu");
        Address e4 =new Address(4,"padi","chennai",604204,"tamilnadu");
        Address e5 =new Address(5,"ttt","trichy",604204,"tamilnadu");
        Address e6 =new Address(6,"sss","salem",604204,"tamilnadu");
        Address e7 =new Address(7,"pallavaram","chennai",604204,"tamilnadu");
        Address e8 =new Address(8,"triplicane","chennai",604204,"tamilnadu");
        Address e9 =new Address(9,"anna nagar","chennai",604204,"tamilnadu");
        Address e10 =new Address(10,"thittakudi","viruthachalam",604204,"tamilnadu");
        addressMap.put(e1.getId(),e1);
        addressMap.put(e2.getId(),e2);
        addressMap.put(e3.getId(),e3);
        addressMap.put(e4.getId(),e4);
        addressMap.put(e5.getId(),e5);
        addressMap.put(e6.getId(),e6);
        addressMap.put(e7.getId(),e7);
        addressMap.put(e8.getId(),e8);
        addressMap.put(e9.getId(),e9);
        addressMap.put(e10.getId(),e10);
        return addressMap;
    }
}
