package com.cliente_appointment_service.clients;

import com.cliente_appointment_service.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
 public class ClienteRegisterClient {

        @Autowired
        private WebClient.Builder webClientBuilder;

        public ClienteDTO getClienteDTO(Long clienteId) {
            return webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/cliente/{id}", clienteId)
                    .retrieve()
                    .bodyToMono(ClienteDTO.class)
                    .block();
        }
}


