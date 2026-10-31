package net.malick.customerservice.controllers;


import net.malick.customerservice.entities.Customer;
import net.malick.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping("/customers")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }
}
