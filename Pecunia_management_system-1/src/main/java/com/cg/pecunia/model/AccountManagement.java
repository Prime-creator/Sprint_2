package com.cg.pecunia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@SequenceGenerator(name="seq",initialValue = 984241769,allocationSize = 50)
@Table(name="accountmanagement")
public class AccountManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	private long accountId;
	 @NotNull
	 @Length(max=10)
	private String accountType;
	 @NotNull
	private Double accountBalance;
	//one customer can one account
	 @NotNull
	 @Column(unique=true)
	private long customerId;
	@Override
	public String toString() {
		return "AccountManagement [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", customerId=" + customerId + "]";
	}
	public AccountManagement(long accountId, @NotNull @Length(max = 10) String accountType,
			@NotNull Double accountBalance, @NotNull long customerId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customerId = customerId;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public AccountManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
