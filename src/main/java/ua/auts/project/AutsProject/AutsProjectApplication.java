package ua.auts.project.AutsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AutsProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutsProjectApplication.class, args);
	}
}
