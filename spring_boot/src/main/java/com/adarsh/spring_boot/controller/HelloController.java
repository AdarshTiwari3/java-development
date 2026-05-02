package com.adarsh.spring_boot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.adarsh.spring_boot.dto.EchoRequest;
import com.adarsh.spring_boot.dto.EchoResponse;
import com.adarsh.spring_boot.dto.RedisValueRequest;
import com.adarsh.spring_boot.dto.RedisValueResponse;
import com.adarsh.spring_boot.service.GreetingService;
import com.adarsh.spring_boot.service.RedisService;
import jakarta.validation.Valid;

@RestController
public class HelloController {

	private final GreetingService greetingService;
	private final RedisService redisService;


	public HelloController(GreetingService greetingService, RedisService redisService) {
		this.greetingService = greetingService;
		this.redisService = redisService;
	}

	@GetMapping("/api")
	String hello() {
		return greetingService.greeting();
	}

	@PostMapping("/api/echo")
	EchoResponse echo(@Valid @RequestBody EchoRequest request) {
		return new EchoResponse(request.message());
	}

	@PostMapping("/api/redis/{key}")
	RedisValueResponse setRedisValue(@PathVariable String key,
			@Valid @RequestBody RedisValueRequest request) {
		redisService.set(key, request.value());
		return new RedisValueResponse(key, request.value());
	}

	@GetMapping("/api/redis/{key}")
	RedisValueResponse getRedisValue(@PathVariable String key) {
		return new RedisValueResponse(key, redisService.get(key));
	}

	@DeleteMapping("/api/redis/{key}")
	void deleteRedisValue(@PathVariable String key) {
		redisService.delete(key);
	}

}
