package com.ezio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class NeteasereviewApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NeteasereviewApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(NeteasereviewApplication.class);
	}
}
