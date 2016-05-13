package com.GasStore.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class GasStoreApplication extends SpringBootServletInitializer{
	// run with Jar file
	public static void main(String[] args) {
		SpringApplication.run(GasStoreApplication.class, args);
	}
	// run with War file
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GasStoreApplication.class);
	}	
}
