package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return DB.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCustomerById(UUID id) {
        Optional<Customer> customerMaybe = selectCustomerById(id);
        if(customerMaybe.isPresent()){
            DB.remove(customerMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCustomerById(UUID id, Customer customer) {
        return selectCustomerById(id)
                .map(cust ->{
                    int indexOfCustomerToUpdate = DB.indexOf(cust);
                    if(indexOfCustomerToUpdate>=0){
                        DB.set(indexOfCustomerToUpdate, new Customer(id, customer.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
