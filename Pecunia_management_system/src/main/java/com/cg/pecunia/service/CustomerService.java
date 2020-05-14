package com.cg.pecunia.service;

import java.util.List;

import com.cg.pecunia.exception.ResourceNotFoundException;
import com.cg.pecunia.model.Customer;

public interface CustomerService {
	//get
	public List<Customer> getCustomers();
	//get by id
	public Customer getCustomerById(long customerId) throws ResourceNotFoundException;
	
	//post
	public String saveCustomer(Customer customer); 
	
	//delete
	public List<Customer> deleteCustomer(long customerId);
	//update
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException;
}
