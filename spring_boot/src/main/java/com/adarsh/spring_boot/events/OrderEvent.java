package com.adarsh.spring_boot.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderEvent(
        @NotBlank(message = "orderId must not be blank")
        String orderId,
        @NotBlank(message = "userId must not be blank")
        String userId,
        @NotNull(message = "totalAmount must not be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "totalAmount must be greater than 0")
        BigDecimal totalAmount,
        @NotBlank(message = "status must not be blank")
        String status,
        @NotNull(message = "createdAt must not be null")
        Instant createdAt,
        @NotEmpty(message = "items must not be empty")
        List<@Valid OrderItem> items) {
}
