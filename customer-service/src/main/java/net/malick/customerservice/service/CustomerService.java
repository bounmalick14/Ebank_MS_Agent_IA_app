package net.malick.customerservice.service;


import net.malick.customerservice.entities.Customer;
import net.malick.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
    return customerRepository.findAll();
  }

  public Customer findCustomerById(Long id){
     return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
  }
  public void saveCustomer(Customer customer){
     customerRepository.save(customer);
  }

}