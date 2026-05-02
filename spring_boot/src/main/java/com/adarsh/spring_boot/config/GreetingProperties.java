package com.adarsh.spring_boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record GreetingProperties(String greeting) {

	public GreetingProperties {
		if (greeting == null || greeting.isBlank()) {
			greeting = "Hello World";
		}
	}

}
