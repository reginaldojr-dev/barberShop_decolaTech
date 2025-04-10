package com.cliente_appointment_service.clients;

import com.cliente_appointment_service.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClienteRegisterClient {

    private final WebClient webClient;

    @Value("${cliente-register-service.url}")
    private String clienteServiceUrl;

    public ClienteRegisterClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public ClienteDTO getClienteDTO(Long clienteId) {
        return webClient
                .get()
                .uri(clienteServiceUrl + "/cliente/{id}", clienteId)
                .retrieve()
                .bodyToMono(ClienteDTO.class)
                .block();
    }
}
