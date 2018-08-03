package com.cache.CacheImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheImplementationApplication {

	public static void main(String[] args) {

		SpringApplication.run(CacheImplementationApplication.class, args);
	}
}
