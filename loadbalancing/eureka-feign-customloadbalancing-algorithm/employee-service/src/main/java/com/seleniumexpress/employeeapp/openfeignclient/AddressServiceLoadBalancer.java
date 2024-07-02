package com.seleniumexpress.employeeapp.openfeignclient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

// NEED TO TEST THE LOADBALANCING ALGORITH MY RUNNING MULTIPLE INSTANCE - NOW MULTIPLE IS NOT REGISTERING IN MY EUREKA DISCOVERY CLIENT, ONCE PROBLEM RESOLVED THEN CHECK HOW IT IS WORKING


//use the value property here instead of name property - do some research about it
//note: if i remove the configuration property, then my custom load balancer will not work. then normal round robin is used here.
@LoadBalancerClient(value= "ADDRESS-SERVICE",configuration = MyCustomLoadBalancerConfiguration.class)
public class AddressServiceLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
