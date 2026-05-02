package com.adarsh.spring_boot.exception;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException exception,
			HttpServletRequest request) {
		Map<String, String> fieldErrors = new LinkedHashMap<>();
		exception.getBindingResult().getFieldErrors()
				.forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.badRequest()
				.body(buildError(HttpStatus.BAD_REQUEST, "Validation failed",
						"Request validation failed", request.getRequestURI(), fieldErrors));
	}

	@ExceptionHandler(RedisKeyNotFoundException.class)
	public ResponseEntity<ApiError> handleRedisKeyNotFound(RedisKeyNotFoundException exception,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(buildError(HttpStatus.NOT_FOUND, "Redis key not found",
						exception.getMessage(), request.getRequestURI(), Map.of()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleUnexpected(Exception exception, HttpServletRequest request) {
		log.error("Unhandled exception for {} {}", request.getMethod(), request.getRequestURI(), exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(buildError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error",
						"An unexpected error occurred", request.getRequestURI(), Map.of()));
	}

	private ApiError buildError(HttpStatus status, String error, String message, String path,
			Map<String, String> fieldErrors) {
		return new ApiError(Instant.now(), status.value(), error, message, path, fieldErrors);
	}

}
