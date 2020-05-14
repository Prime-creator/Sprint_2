package com.cg.pecunia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pecunia.exception.ResourceNotFoundException;
import com.cg.pecunia.model.Customer;
import com.cg.pecunia.repository.CustomerRepository;
import com.cg.pecunia.service.CustomerService;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	@HystrixCommand(fallbackMethod = "fallBackAddCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		LOGGER.info("adding customer");
		return "Customer ID: "+customer.getCustomerId();
	}
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer findCustomerById(@PathVariable long customerId) throws ResourceNotFoundException {
		return customerService.getCustomerById(customerId);
	}
	
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) throws ResourceNotFoundException{
		System.out.println("customer hello"+customer);
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public List<Customer> deleteCustomer(@PathVariable long customerId) {
		return customerService.deleteCustomer(customerId);
	}
	
	public String fallBackAddCustomer(@RequestBody Customer customer) {
		return "addCustomer Service failed";
	}
}
