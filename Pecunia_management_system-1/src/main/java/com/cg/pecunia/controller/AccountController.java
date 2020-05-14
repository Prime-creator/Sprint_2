package com.cg.pecunia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pecunia.exception.ResourceNotFoundException;
import com.cg.pecunia.model.AccountManagement;
import com.cg.pecunia.service.AccountService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	public AccountService service;
	
	@PostMapping("/addAccount")
	public String createAccount(@RequestBody AccountManagement accountObj)throws ResourceNotFoundException{
		
		return service.createAccount(accountObj);
		
	}
	
	@GetMapping("/showAccounts")
	public List<AccountManagement> findAllCustomers(){
		return service.getAccounts();
	}
	
	@DeleteMapping("/deleteAccount/{customerId}")
	public String deleteAccount(@PathVariable long customerId) {
		 service.deleteAccount(customerId);
		 return "deleted";
	}
	
}
