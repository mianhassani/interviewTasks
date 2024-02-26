package com.example.interview;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomersRepository customersRepository;

  public void addCustomer(Customer customer) {
    customersRepository.save(customer);
  }

  public List<Customer> getCustomers() {
    return customersRepository.findAll();
  }

  public Customer getCustomerById(Long id) {
    Optional<Customer> customerOptional = customersRepository.findById(id);
   return customerOptional.orElseGet(customerOptional::orElseThrow);
  }

}
