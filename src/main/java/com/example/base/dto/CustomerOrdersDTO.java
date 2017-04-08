package com.example.base.dto;

import java.util.Set;

import com.example.base.entity.DemoOrders;

public class CustomerOrdersDTO {

	private Long customerId;
	private String custFirstName;
	private String custLastName;
	private String custState;

	private Set<DemoOrders> orders;

	public CustomerOrdersDTO() {
	}

	public CustomerOrdersDTO(Long customerId, String custFirstName, String custLastName, String custState) {
		this.customerId = customerId;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custState = custState;
	}

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

	public Set<DemoOrders> getOrders() {
		return orders;
	}

	public void setOrders(Set<DemoOrders> orders) {
		this.orders = orders;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	@Override
	public String toString() {
		return "CustomerOrdersDTO [customerId=" + customerId + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custState=" + custState + ", orders=" + orders + "]";
	}

}
