package com.jpmc.theater.services;

import java.util.List;

import com.jpmc.theater.entities.Customer;
import com.jpmc.theater.repositories.ICustomerRepositoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreationService {
    
    @Autowired
    ICustomerRepositoy customerRepositoy;

    public Customer getCustomerById(int id){
        return customerRepositoy.getReferenceById(id);
    }

    public List<Customer> getCustomerByName(@Param("name") String name){
        return customerRepositoy.getCustomerByName(name);
    }


    public Customer createCustomer(String name){
        return customerRepositoy.save(new Customer(name));
    }
}
