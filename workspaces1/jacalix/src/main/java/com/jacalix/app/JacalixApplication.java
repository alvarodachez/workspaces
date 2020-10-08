package jacalix.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"jacalix.restController","jacalix.restService"})
public class JacalixApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacalixApplication.class, args);
	}

}
