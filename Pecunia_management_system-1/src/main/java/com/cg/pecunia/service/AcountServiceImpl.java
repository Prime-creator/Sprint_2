package com.cg.pecunia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.pecunia.exception.ResourceNotFoundException;
import com.cg.pecunia.model.AccountManagement;
import com.cg.pecunia.repo.AccountRepo;


@Service
public class AcountServiceImpl implements AccountService {

	@Autowired
	AccountRepo repo;
	
	final String ROOT_URL = "http://localhost:8100/api/v1";
	
	@Autowired
	RestTemplate rest;

	@Transactional
	@Override
	public String createAccount(AccountManagement accountObj)throws ResourceNotFoundException {
		
		Object customerObj = rest.getForObject(ROOT_URL+"/customer/"+accountObj.getCustomerId(), Object.class);
		
		System.out.println("customerid = "+ customerObj);
		if(customerObj != null) {
			return String.valueOf(repo.save(accountObj).getAccountId());
		}else {
			//throw new ResourceNotFoundException("customer does not exist");
			return "customer does not exist";
		}		
	}
	
	@Transactional
	@Override
	public List<AccountManagement> getAccounts() {
		
		return repo.findAll();
	}
	
	@Transactional
	@Override
	public String deleteAccount(long customerId){
		long accountId = repo.getId(customerId);
		 repo.deleteById(accountId);
		 return "deleted";
	}
	
}
