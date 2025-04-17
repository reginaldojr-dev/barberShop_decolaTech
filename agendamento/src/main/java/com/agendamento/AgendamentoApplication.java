package com.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.agendamento.clients")
public class AgendamentoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgendamentoApplication.class, args);
	}
}
