package com.cg.pecunia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.pecunia.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public String deleteByCustomerId(long customerId);
	
}
