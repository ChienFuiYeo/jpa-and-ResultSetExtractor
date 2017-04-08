package com.example.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.base.dao.DemoCustomersDao;
import com.example.base.dto.CustomerOrdersDTO;
import com.example.base.dto.CustomerOrdersDTOExtractor;

@Service
public class DemoCustomersDaoImpl implements DemoCustomersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerOrdersDTO> findByCustomerId(Long customerId) {
		String query = new StringBuilder("SELECT ") //
				.append("c.CUSTOMER_ID as customerId, c.CUST_FIRST_NAME as custFirstName, c.CUST_LAST_NAME as custLastName, ") //
				.append("(select s.STATE_NAME from DEMO_STATES s where s.ST=c.CUST_STATE) as custState, ") //
				.append("o.ORDER_ID as orderId, o.ORDER_TOTAL as orderTotal, o.ORDER_TIMESTAMP as orderTimestamp, o.USER_ID as userId ") //
				.append("FROM DEMO_CUSTOMERS c ") //
				.append("JOIN DEMO_ORDERS o ON c.CUSTOMER_ID=o.CUSTOMER_ID ") //
				.append("WHERE c.CUSTOMER_ID=?") //
				.toString();
		
		return jdbcTemplate.query(query, new Object[] { customerId }, new CustomerOrdersDTOExtractor());
	}
}
