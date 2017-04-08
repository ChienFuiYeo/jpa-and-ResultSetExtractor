package com.example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
	// RouterFunction<?> routingFunction(DemoCustomersHandler
	// demoCustomersHandler) {
	// return RouterFunctions //
	// .route(RequestPredicates.GET("/customers"), demoCustomersHandler::all) //
	// .andRoute(RequestPredicates.GET("/customers/{id}"),
	// demoCustomersHandler::findByCustomerId);
	// }
	//
	// @Bean
	// HttpServer httpServer(RouterFunction<?> routingFunction) {
	// HttpWebHandlerAdapter httpHandler =
	// RouterFunctions.toHttpHandler(routingFunction);
	// ReactorHttpHandlerAdapter adapter = new
	// ReactorHttpHandlerAdapter(httpHandler);
	// HttpServer server = HttpServer.create("localhost", 7001);
	// server.newHandler(adapter).block();
	//
	// return server;
	// }
}