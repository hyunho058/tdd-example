package com.example.tddexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TddExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddExampleApplication.class, args);
	}

}
