package com.sathya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

   @SpringBootApplication
   public class UiTechnologyToMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiTechnologyToMicroServiceApplication.class, args);
	}
    
	@Bean
	public RestTemplate restTemaplate()
	{
		return new RestTemplate();
	}

}
