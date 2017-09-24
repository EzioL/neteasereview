package com.ezio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class NeteasereviewApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NeteasereviewApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(NeteasereviewApplication.class);
	}


	@GetMapping("/")
	public String index() {
		return "index";
	}

}
