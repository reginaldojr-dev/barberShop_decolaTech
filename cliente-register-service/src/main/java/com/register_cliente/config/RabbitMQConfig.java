package com.register_cliente.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue petCreatedQueue() {
        return new Queue("cliente_created", true);
    }

    @Bean
    public Queue petRequestsQueue() {
        return new Queue("cliente.requests", true);
    }

    @Bean
    public Queue petResponsesQueue() {
        return new Queue("cliente.responses", true);
    }
}
