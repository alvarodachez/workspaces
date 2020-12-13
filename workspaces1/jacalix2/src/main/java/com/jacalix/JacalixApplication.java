package com.jacalix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.jacalix.restController", "com.jacalix.restService" })
@EntityScan(basePackages = { "com.jacalix.model.entity" })
@EnableJpaRepositories(basePackages = { "com.jacalix.repo" })
public class JacalixApplication implements CommandLineRunner {

	//@Autowired
	//CompressService cs;

	public static void main(String[] args) {
		SpringApplication.run(JacalixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//cs.createZip();
	}

}
