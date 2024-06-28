package com.letmeask.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LetmeaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetmeaskApplication.class, args);

		System.out.println("\nApi rodando...\n");
	}

}
