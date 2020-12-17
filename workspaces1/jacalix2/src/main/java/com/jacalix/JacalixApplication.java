package com.jacalix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jacalix.model.entity.Customer;
import com.jacalix.model.entity.Subscription;
import com.jacalix.model.entity.SubscriptionType;
import com.jacalix.model.entity.UserType;
import com.jacalix.repo.CustomerRepository;
import com.jacalix.repo.SubscriptionRepository;

@SpringBootApplication(scanBasePackages = { "com.jacalix.restController", "com.jacalix.restService" })
@EntityScan(basePackages = { "com.jacalix.model.entity" })
@EnableJpaRepositories(basePackages = { "com.jacalix.repo" })
public class JacalixApplication implements CommandLineRunner {

	// @Autowired
	// CompressService cs;
	@Autowired
	private CustomerRepository cs;
	
	@Autowired
	private SubscriptionRepository sr;

	public static void main(String[] args) {
		SpringApplication.run(JacalixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// cs.createZip();

		Customer admin = new Customer();
		Subscription subGold = new Subscription();
		
		subGold.setRentType(SubscriptionType.GOLD);
		sr.save(subGold);

		
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setAge(99);
		admin.setDni("SoyAdmin");
		admin.setName("Administrador");
		admin.setSurname("Guapeton");
		admin.setSub(subGold);
		admin.setUserType(UserType.ADMIN);

		cs.save(admin);
	}

}
