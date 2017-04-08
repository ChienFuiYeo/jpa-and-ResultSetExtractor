package com.example.base.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.base.entity.DemoOrders;

public class CustomerOrdersDTOExtractor implements ResultSetExtractor<List<CustomerOrdersDTO>> {

	@Override
	public List<CustomerOrdersDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, CustomerOrdersDTO> customerOrdersDTOMap = new HashMap<Long, CustomerOrdersDTO>();
		Set<DemoOrders> orders = null;
		DemoOrders demoOrders = null;
		Predicate<DemoOrders> noSimilarOrderId = null;
		CustomerOrdersDTO customerOrdersDTO = null;

		while (rs.next()) {
			Long customerId = rs.getLong("customerId");
			customerOrdersDTO = customerOrdersDTOMap.get(customerId);

			if (null == customerOrdersDTO) {
				customerOrdersDTO = new CustomerOrdersDTO();
				customerOrdersDTO.setCustFirstName(rs.getString("custFirstName"));
				customerOrdersDTO.setCustLastName(rs.getString("custLastName"));
				customerOrdersDTO.setCustState(rs.getString("custState"));

				orders = new HashSet<DemoOrders>();
			} else {
				orders = customerOrdersDTO.getOrders();
			}

			noSimilarOrderId = d -> {
				try {
					return d.getOrderId().compareTo(rs.getLong("orderId")) != 0;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			};

			if (orders.stream().allMatch(noSimilarOrderId)) {
				demoOrders = new DemoOrders();
				demoOrders.setCustomerId(customerId);
				demoOrders.setOrderId(rs.getLong("orderId"));
				demoOrders.setOrderTotal(rs.getBigDecimal("orderTotal"));
				demoOrders.setOrderTimestamp(rs.getDate("orderTimestamp"));
				demoOrders.setUserId(rs.getLong("userId"));
				orders.add(demoOrders);
			}

			customerOrdersDTO.setOrders(orders);
			customerOrdersDTOMap.put(customerId, customerOrdersDTO);
		}
		return new ArrayList<CustomerOrdersDTO>(customerOrdersDTOMap.values());
	}

}
