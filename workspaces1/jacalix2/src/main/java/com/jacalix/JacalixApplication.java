package jacalix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"jacalix.restController","jacalix.restService"})
@EntityScan(basePackages ={"jacalix.model.entity"})
@EnableJpaRepositories(basePackages = {"*"})
public class JacalixApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacalixApplication.class, args);
	}

}
