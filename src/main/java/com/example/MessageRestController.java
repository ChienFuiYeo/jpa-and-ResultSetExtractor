package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
public class MessageRestController {

	@Value("${message:Hello default}")
	private String message;

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	String getMessage() {
		return this.message;
	}

}
