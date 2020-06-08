package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDao {
    //inserts a customer that had an id prior
    int insertCustomer(UUID id, Customer customer);
    //adds a newly registered customer that had no id prior
    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id,customer);
    }

    List<Customer> SelectAllCustomer();
}
