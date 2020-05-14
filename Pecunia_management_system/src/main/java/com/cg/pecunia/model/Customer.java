package com.cg.pecunia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@SequenceGenerator(name="seq",initialValue = 1052917149,allocationSize = 50)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	private long customerId;
	@NotNull
	@Length(max = 20, min=3)
	private String customerName;
	@NotNull
	@Length(max = 10, min = 10)
	private String customerPAN;
	@Length(max = 12, min = 12)
	@NotNull
	private String customerAadhar;
	@Length(max = 10, min = 10)
	@NotNull
	private String customerContact;
	@NotNull
	@Length(max = 6)
	private String customerGender;
	@NotNull
	@Length(max = 20, min = 4)
	private String customerDob;
	@NotNull
	@Length(max = 50, min = 5)
	private String permanentAddress;
	@NotNull
	@Length(max = 30, min = 5)
	private String customerState;
	@NotNull
	@Length(max = 30, min = 5)
	private String customerCountry;
	@Length(max = 30)
	private String temporaryAddress;

	//one customer can one account
	//one customer can one address
	
	 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	 @Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPAN=" + customerPAN
				+ ", customerAadhar=" + customerAadhar + ", customerContact=" + customerContact + ", customerGender="
				+ customerGender + ", customerDob=" + customerDob + ", permanentAddress=" + permanentAddress
				+ ", customerState=" + customerState + ", customerCountry=" + customerCountry + ", temporaryAddress="
				+ temporaryAddress + "]";
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	public String getTemporaryAddress() {
		return temporaryAddress;
	}
	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	
	public long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPAN() {
		return customerPAN;
	}
	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}
	public String getCustomerAadhar() {
		return customerAadhar;
	}
	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}
	
}
