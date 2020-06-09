package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController//required to be able to use HTTP requests
//GET to retrieve data
//POST to add resource to server
//PUT modify resource from server
//DELETE to delete resource from the server
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping//this is a post in java
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping//this will map to a get with the path api/v1/customer
    public List<Customer> getAllPeople(){
        return customerService.getAllCustomer();
    }
    @GetMapping(path = "{id}")//@PathVariable will tell it that the id is to be used
    public Customer getCustomerById(@PathVariable("id")UUID id){
        return customerService.getCustomerById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")//@PathVariable will tell it that the id is to be used
    public void updateCustomer(@PathVariable("id")UUID id,@RequestBody Customer newcustomer){
        customerService.updateCustomer(id, newcustomer);
    }

    @DeleteMapping(path = "{id}")//@PathVariable will tell it that the id is to be used
    public void deleteCustomerById(@PathVariable("id")UUID id){
        customerService.deleteCustomer(id);
    }
}
