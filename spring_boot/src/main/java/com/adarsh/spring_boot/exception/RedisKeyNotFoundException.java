package com.adarsh.spring_boot.exception;

public class RedisKeyNotFoundException extends RuntimeException {

	public RedisKeyNotFoundException(String key) {
		super("No value found for key: " + key);
	}

}
