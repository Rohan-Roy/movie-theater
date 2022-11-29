package com.jpmc.theater.repositories;

import java.util.List;

import com.jpmc.theater.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepositoy extends JpaRepository<Customer, Integer>{
    
    @Query(value="SELECT * FROM customer WHERE name LIKE %:name%", nativeQuery = true)
    public List<Customer> getCustomerByName(@Param("name") String name);
}
