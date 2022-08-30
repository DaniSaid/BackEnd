package com.portafoliodg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableJpaRepositories
@CrossOrigin(origins = "https://hosting-angular-e585e.web.app")
public class PortafoliodgApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortafoliodgApplication.class, args);
	}
}
