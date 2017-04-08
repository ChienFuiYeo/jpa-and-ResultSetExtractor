package com.example.base.repo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.base.dto.CustomerOrdersDTO;
import com.example.base.entity.DemoCustomers;

@Repository
public interface DemoCustomersRepository extends JpaRepository<DemoCustomers, Long> {

	CompletableFuture<DemoCustomers> findByCustomerId(Long customerId);

	@Query("select c from DemoCustomers c")
	Stream<DemoCustomers> findAllAsStream();

	@Query("select "
			+ "new com.example.base.dto.CustomerOrdersDTO(c.customerId, c.custFirstName, c.custLastName, "
			+ "(select s.stateName from DemoStates s where s.st=c.custState)) "
			+ "from DemoCustomers c "
			+ "where c.customerId = ?1")
	List<CustomerOrdersDTO> findCustomerWithOrder(Long customerId);

}
