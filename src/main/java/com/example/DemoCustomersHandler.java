package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.base.entity.DemoCustomers;
import com.example.base.repo.DemoCustomersRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DemoCustomersHandler {

	@Autowired
	DemoCustomersRepository demoCustomersRepository;

	@Transactional
	public Mono<ServerResponse> all(ServerRequest request) {
		Flux<DemoCustomers> demoCustomer = Flux.fromStream(this.demoCustomersRepository.findAllAsStream());
		return ServerResponse.ok().body(demoCustomer, DemoCustomers.class);
	}

	public Mono<ServerResponse> findByCustomerId(ServerRequest request) {
		Mono<DemoCustomers> demoCustomers = Mono.justOrEmpty(request.pathVariable("id")) //
				.map(Long::valueOf) //
				.map(demoCustomersRepository::findByCustomerId) //
				.then(Mono::fromFuture);
		return ServerResponse.ok().body(BodyInserters.fromPublisher(demoCustomers, DemoCustomers.class));

		// Long customerId = Long.parseLong(request.pathVariable("id"));
		// Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		// return
		// Mono.fromFuture(this.demoCustomersRepository.findByCustomerId(customerId)).then(customer
		// -> {
		// Publisher<DemoCustomers> customerPublisher = Mono.just(customer);
		// return ServerResponse.ok().body(customerPublisher,
		// DemoCustomers.class);
		// }).otherwiseIfEmpty(notFound);
	}

}