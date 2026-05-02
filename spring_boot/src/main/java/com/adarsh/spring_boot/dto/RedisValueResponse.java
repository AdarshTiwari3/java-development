package com.adarsh.spring_boot.dto;

import com.fasterxml.jackson.databind.JsonNode;

public record RedisValueResponse(String key, JsonNode value) {
}
