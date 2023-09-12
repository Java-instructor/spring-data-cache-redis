package com.java.instructor.spring.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;

@SpringBootApplication
@EnableCaching  // if this annotation not enabled. then cache will not work even if you used any other cache related notation. 
public class SpringRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisCacheApplication.class, args);
	}

}
