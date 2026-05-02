package com.adarsh.spring_boot.service;

import org.springframework.stereotype.Service;

import com.adarsh.spring_boot.config.GreetingProperties;

@Service
public class GreetingService {

	private final GreetingProperties greetingProperties;

	public GreetingService(GreetingProperties greetingProperties) {
		this.greetingProperties = greetingProperties;
	}

	public String greeting() {
		return greetingProperties.greeting();
	}

}
