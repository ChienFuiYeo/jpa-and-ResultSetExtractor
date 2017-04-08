package com.example.base.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_CUSTOMERS")
public class DemoCustomers {

	@Id
	@SequenceGenerator(name = "DEMO_CUST_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_CUST_SEQ")
	private Long customerId;
	private String custFirstName;
	private String custLastName;
	private String custStreetAddress1;
	private String custStreetAddress2;
	private String custCity;
	private String custState;
	private String custPostalCode;
	private String phoneNumber1;
	private String phoneNumber2;
	private BigDecimal creditLimit;
	private String custEmail;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustStreetAddress1() {
		return custStreetAddress1;
	}

	public void setCustStreetAddress1(String custStreetAddress1) {
		this.custStreetAddress1 = custStreetAddress1;
	}

	public String getCustStreetAddress2() {
		return custStreetAddress2;
	}

	public void setCustStreetAddress2(String custStreetAddress2) {
		this.custStreetAddress2 = custStreetAddress2;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustPostalCode() {
		return custPostalCode;
	}

	public void setCustPostalCode(String custPostalCode) {
		this.custPostalCode = custPostalCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "DemoCustomers [customerId=" + customerId + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custStreetAddress1=" + custStreetAddress1 + ", custStreetAddress2="
				+ custStreetAddress2 + ", custCity=" + custCity + ", custState=" + custState + ", custPostalCode="
				+ custPostalCode + ", phoneNumber1=" + phoneNumber1 + ", phoneNumber2=" + phoneNumber2
				+ ", creditLimit=" + creditLimit + ", custEmail=" + custEmail + "]";
	}
}