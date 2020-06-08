package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping//this is a get in java
    public List<Customer> getAllPeople(){
        return customerService.getAllCustomer();
    }
}
