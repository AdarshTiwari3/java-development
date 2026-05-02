package com.adarsh.spring_boot.events;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItem(
        @NotBlank(message = "productId must not be blank")
        String productId,
        @Positive(message = "quantity must be greater than 0")
        int quantity,
        @NotNull(message = "price must not be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0")
        BigDecimal price) {
}
