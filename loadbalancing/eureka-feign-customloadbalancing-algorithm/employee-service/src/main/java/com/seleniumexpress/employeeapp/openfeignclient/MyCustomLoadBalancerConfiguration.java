package com.seleniumexpress.employeeapp.openfeignclient;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


public class MyCustomLoadBalancerConfiguration {

    // NEED TO TEST THE LOADBALANCING ALGORITH MY RUNNING MULTIPLE INSTANCE - NOW MULTIPLE IS NOT REGISTERING IN MY EUREKA DISCOVERY CLIENT, ONCE PROBLEM RESOLVED THEN CHECK HOW IT IS WORKING

    //This algorithm randomely balance the load without following any order unlike round robin algorithm
        @Bean
        ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                                LoadBalancerClientFactory loadBalancerClientFactory) {
            String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
            return new RandomLoadBalancer(loadBalancerClientFactory
                    .getLazyProvider(name, ServiceInstanceListSupplier.class),
                    name);
        }
}