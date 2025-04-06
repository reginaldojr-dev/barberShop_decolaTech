package com.register_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("com.register_cliente.repositories")
@EntityScan("com.register_cliente.models")
public class ClienteRegisterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClienteRegisterApplication.class, args);
	}
}