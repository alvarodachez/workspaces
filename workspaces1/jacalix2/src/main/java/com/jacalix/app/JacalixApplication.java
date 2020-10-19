package jacalix.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jacalix.model.entity.Customer;
import jacalix.model.entity.Product;
import jacalix.model.entity.Subscription;
import jacalix.model.entity.View;

@SpringBootApplication(scanBasePackages = {"jacalix.restController","jacalix.restService"})
@EntityScan(basePackageClasses ={Customer.class,Product.class,Subscription.class,View.class})
public class JacalixApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacalixApplication.class, args);
	}

}
