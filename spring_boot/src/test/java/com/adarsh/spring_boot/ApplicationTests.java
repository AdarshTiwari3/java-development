package com.adarsh.spring_boot;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.adarsh.spring_boot.config.GreetingProperties;
import com.adarsh.spring_boot.controller.HelloController;
import com.adarsh.spring_boot.exception.GlobalExceptionHandler;
import com.adarsh.spring_boot.service.GreetingService;
import com.adarsh.spring_boot.service.RedisService;

@WebMvcTest(HelloController.class)
@EnableConfigurationProperties(GreetingProperties.class)
@org.springframework.context.annotation.Import({GreetingService.class,
		GlobalExceptionHandler.class})
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RedisService redisService;

	@BeforeEach
	void setUp() {
		doNothing().when(redisService).delete("sample-key");
	}

	@Test
	void apiReturnsHelloWorld() throws Exception {
		mockMvc.perform(get("/api")).andExpect(status().isOk())
				.andExpect(content().string("Hello Adarsh"));
	}

	@Test
	void echoRejectsBlankMessage() throws Exception {
		mockMvc.perform(post("/api/echo").contentType(MediaType.APPLICATION_JSON).content("""
				{"message":""}
				""")).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.error").value("Validation failed"))
				.andExpect(jsonPath("$.fieldErrors.message").value("message must not be blank"));
	}



}
