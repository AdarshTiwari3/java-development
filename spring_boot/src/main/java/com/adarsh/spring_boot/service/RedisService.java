package com.adarsh.spring_boot.service;

import java.time.Duration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.adarsh.spring_boot.exception.RedisKeyNotFoundException;

@Service
public class RedisService {

	private static final Duration DEFAULT_TTL = Duration.ofSeconds(50l);

	private final RedisTemplate<String, Object> redisTemplate;
	private final ObjectMapper objectMapper;

	public RedisService(RedisTemplate<String, Object> redisTemplate, ObjectMapper objectMapper) {
		this.redisTemplate = redisTemplate;
		this.objectMapper = objectMapper;
	}

	public void set(String key, JsonNode value) {
		redisTemplate.opsForValue().set(key, value, DEFAULT_TTL);
	}

	public JsonNode get(String key) {
		Object value = redisTemplate.opsForValue().get(key);
		if (value == null) {
			throw new RedisKeyNotFoundException(key);
		}
		return objectMapper.valueToTree(value);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}

}
