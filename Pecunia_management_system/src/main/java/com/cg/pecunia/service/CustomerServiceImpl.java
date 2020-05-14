package com.cg.pecunia.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.pecunia.exception.ResourceNotFoundException;
import com.cg.pecunia.model.Customer;
import com.cg.pecunia.repository.CustomerRepository;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo; 
	
	@Autowired
	RestTemplate rest = new RestTemplate();
	
	final String ROOTURL = "http://localhost:8200/api/v1";
	
	@Override
	public List<Customer> getCustomers(){
		
		return customerRepo.findAll();
	}
	
	@Override
	public Customer getCustomerById(long customerId) throws ResourceNotFoundException{
		return customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("customer not found for this id :: " + customerId));
	};
	@Override
	public String saveCustomer(Customer customer) {
		 customerRepo.save(customer);
		 return "customer id: "+customer.getCustomerId();
	}

	@Override
	public List<Customer> deleteCustomer(long customerId) {
		customerRepo.deleteByCustomerId(customerId);
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException{
		Optional<Customer> existingCustomer = customerRepo.findById(customer.getCustomerId());
		if(existingCustomer.isPresent()) {
			Customer update = existingCustomer.get();
			//update.setCustomerName(customer.getCustomerName());
			update.setCustomerAadhar(customer.getCustomerAadhar());
			update.setCustomerContact(customer.getCustomerContact());
			update.setCustomerDob(customer.getCustomerDob());
			update.setCustomerGender(customer.getCustomerGender());
			update.setCustomerName(customer.getCustomerName());
			update.setCustomerPAN(customer.getCustomerPAN());
			update.setPermanentAddress(customer.getPermanentAddress());
			update.setTemporaryAddress(customer.getTemporaryAddress());
			update.setCustomerCountry(customer.getCustomerCountry());
			update.setCustomerState(customer.getCustomerState());
			return customerRepo.save(update);
				
		}
		return new Customer();
	}

}
