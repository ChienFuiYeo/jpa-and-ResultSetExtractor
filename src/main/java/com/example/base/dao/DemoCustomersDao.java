package com.example.base.dao;

import java.util.List;

import com.example.base.dto.CustomerOrdersDTO;

public interface DemoCustomersDao {

	List<CustomerOrdersDTO> findByCustomerId(final Long customerId);
}
