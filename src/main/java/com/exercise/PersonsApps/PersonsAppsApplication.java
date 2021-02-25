package com.exercise.PersonsApps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonsAppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonsAppsApplication.class, args);
	}

}
