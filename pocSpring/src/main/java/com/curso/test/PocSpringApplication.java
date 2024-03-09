package com.curso.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class PocSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	   // Do any additional configuration here
	   return new RestTemplate();
	}
	
}
