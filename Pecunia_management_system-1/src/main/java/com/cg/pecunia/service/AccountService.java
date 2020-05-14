package com.cg.pecunia.service;

import java.util.List;

import com.cg.pecunia.exception.ResourceNotFoundException;
import com.cg.pecunia.model.AccountManagement;



public interface AccountService {
	
	//post request
	public String createAccount(AccountManagement accountObj)throws ResourceNotFoundException;

	//get request
	public List<AccountManagement> getAccounts();

	//delete
	public String deleteAccount(long customerId);
}
