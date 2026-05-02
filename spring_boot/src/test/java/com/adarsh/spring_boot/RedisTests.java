package com.adarsh.spring_boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@Disabled("Requires local redis server")
public class RedisTests {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedisConnection() {
        redisTemplate.opsForValue().set("test", "hello", Duration.ofSeconds(15l));
        String value = redisTemplate.opsForValue().get("test");

        assertEquals("hello", value);

        redisTemplate.delete("test");

    }

}
