package com.example.interview;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customers")
public class Controller {

  private final CustomerService customerService;

  @Autowired
  public Controller(CustomerService customerService){
    this.customerService = customerService;
  }

  @GetMapping(produces ="application/json" )
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @GetMapping(value = "/getCustomerById/{id}", produces ="application/json" )
  public Customer getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }

  @PostMapping(value = "/addCustomers" )
  public void addCustomers(@RequestBody Customer customer) {
    customerService.addCustomer(customer);
  }
}
