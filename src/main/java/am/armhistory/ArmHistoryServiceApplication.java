package am.armhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-config.xml")
public class ArmHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmHistoryServiceApplication.class, args);
	}
}
