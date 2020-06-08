package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//replace fakeDao by MySQL if need be, if you are using MySQL
@Repository("fakeDao")
public class FakeCustomerDataAccessService implements CustomerDao{

    private static List<Customer> DB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id, customer.getName()));
        return 1;
    }

    @Override
    public List<Customer> SelectAllCustomer() {
        return DB;
    }
}
