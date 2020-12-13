package com.jacaranda.ahorcado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.jacaranda.restcontroller", "com.jacaranda.services","com.jacaranda.services_impl" })
@EntityScan(basePackages = { "com.jacaranda.model" })
@EnableJpaRepositories(basePackages = { "com.jacaranda.repository" })
public class AhorcadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhorcadoApplication.class, args);
	}

}
