package com.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.dao.DemoCustomersDao;
import com.example.base.dto.CustomerOrdersDTO;
import com.example.base.entity.DemoCustomers;
import com.example.base.entity.DemoOrders;
import com.example.base.repo.DemoCustomersRepository;
import com.example.base.repo.DemoOrdersRepository;

@RestController
@RequestMapping("/custs")
public class CustomerApi {

	@Autowired
	private DemoCustomersRepository demoCustomersRepository;

	@Autowired
	private DemoOrdersRepository demoOrdersRepository;
	@Autowired
	private DemoCustomersDao demoCustomersDao;

	@RequestMapping(method = RequestMethod.GET)
	@Transactional(readOnly = true)
	public ResponseEntity<List<DemoCustomers>> getCusts() {
		return ResponseEntity.ok(demoCustomersRepository.findAllAsStream().collect(Collectors.toList()));
	}

	@RequestMapping(value = "{custId}", method = RequestMethod.GET)
	public ResponseEntity<DemoCustomers> getCustByCustId(@PathVariable String custId)
			throws NumberFormatException, InterruptedException, ExecutionException {
		return ResponseEntity.ok(demoCustomersRepository.findByCustomerId(Long.parseLong(custId)).get());
	}

	@RequestMapping(value = "{custId}/custOrders", method = RequestMethod.GET)
	public ResponseEntity<Set<DemoOrders>> getCustOrderByCustId(@PathVariable String custId)
			throws NumberFormatException, InterruptedException, ExecutionException {
		return ResponseEntity.ok(demoOrdersRepository.findByCustomerId(Long.parseLong(custId)).get());
	}

	@RequestMapping(value = "{custId}/custWithOrders", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerOrdersDTO>> getCustWithOrderByCustId(@PathVariable String custId)
			throws NumberFormatException, InterruptedException, ExecutionException {
		List<CustomerOrdersDTO> result = demoCustomersRepository.findCustomerWithOrder(Long.parseLong(custId));

		result.forEach(each -> {
			try {
				each.setOrders(new HashSet<DemoOrders>(demoOrdersRepository.findByCustomerId(each.getCustomerId()).get()));
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{custId}/custWithOrdersByExtractor", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerOrdersDTO>> getCustWithOrdersByExtractor(@PathVariable String custId)
			throws NumberFormatException, InterruptedException, ExecutionException {
		return ResponseEntity.ok(demoCustomersDao.findByCustomerId(Long.parseLong(custId)));
	}

}
