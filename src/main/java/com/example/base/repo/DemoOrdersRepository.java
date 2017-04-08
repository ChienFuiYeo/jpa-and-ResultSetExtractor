package com.example.base.repo;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.base.entity.DemoOrders;

@Repository
public interface DemoOrdersRepository extends JpaRepository<DemoOrders, Long> {

	CompletableFuture<DemoOrders> findByOrderId(Long orderId);

	CompletableFuture<Set<DemoOrders>> findByCustomerId(Long customerId);

	@Query("select c from DemoOrders c")
	Stream<DemoOrders> findAllAsStream();
}
