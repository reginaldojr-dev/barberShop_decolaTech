package com.cliente_appointment_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue clienteCreatedQueue() {
        return new Queue("cliente_created", true);
    }

    @Bean
    public Queue appointmentCreatedQueue() {
        return new Queue("appointment_created", true);
    }

    @Bean
    public Queue clienteInfoRequestsQueue() {
        return new Queue("cliente.requests", true);
    }

    @Bean
    public Queue clienteInfoResponsesQueue() {
        return new Queue("cliente.responses", true);
    }
}
