package com.adarsh.spring_boot.dto;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;

public record RedisValueRequest(@NotNull(message = "value must not be null") JsonNode value) {
}
