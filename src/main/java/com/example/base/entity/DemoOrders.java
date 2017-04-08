package com.example.base.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_ORDERS")
public class DemoOrders {

	@Id
	@SequenceGenerator(name = "DEMO_ORD_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_ORD_SEQ")
	private Long orderId;
	private Long customerId;
	private BigDecimal orderTotal;
	private Date orderTimestamp;
	private Long userId;

	public DemoOrders(){
	}
	
	public DemoOrders(Long orderId){
		this.orderId = orderId;
	}
	
	public DemoOrders(Long orderId, BigDecimal orderTotal, Date orderTimestamp, Long userId) {
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.orderTimestamp = orderTimestamp;
		this.userId = userId;
	}

	public DemoOrders(Long orderId, Long customerId, BigDecimal orderTotal, Date orderTimestamp, Long userId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderTotal = orderTotal;
		this.orderTimestamp = orderTimestamp;
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Date getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Date orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoOrders other = (DemoOrders) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemoOrders [orderId=" + orderId + ", customerId=" + customerId + ", orderTotal=" + orderTotal
				+ ", orderTimestamp=" + orderTimestamp + ", userId=" + userId + "]";
	}

}
